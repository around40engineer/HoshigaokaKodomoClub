.PHONY: lint frontend-test backend-test push all
SUCCESS_WORDS := テスト成功 HappyHappyHappy 峰竜太 ちょろいっすわ いいですね 桃ちゃん 俺は高校生探偵、ひさどみサトシ 空前絶後の、超絶怒涛のピン芸人！笑いを愛し　笑いに愛された男！漫才、コント、落語、すべての笑いの生みの親ー！人呼んで、七福神８人目の笑いの神！そう、この俺こそは！たとえこの身が朽ち果てようと、笑いを求めて命を燃やし、燃えた炎は星となり、見る者すべてを笑顔に変える！みんなご存知！そうこの俺こそは…。最強無敵のピン芸人！あまりのポテンシャルの高さに、松竹、吉本、人力舎、太田プロ、マセキから命を狙われている男！そうこの俺こそは…。天下無双のピン芸人！あの日本一の池崎を決める大会『池崎-１グランプリ』セミファイナリスト、この俺はー！身長１７３cm、体重６３kg。長所、明るいところ。短所、コミュニケーション能力の欠如！お笑い界に舞い降りた、キングオブ人見知り！そう、この俺はー！昭和５６年生まれ、出身地は母親！家族構成、父・ガイア池崎、母・ポセイドン池崎、兄・ともかず！そう、皆お待ちかね、次男で末っ子、この俺は…サンシャイン池…袋の近くで普段アルバイトしてます！時給１２４０円。貯金残高８万４８００円、キャッシュカードの暗証番号８９３１！楽屋袖の芸人の皆、いまがチャンスでーす！もう一度いいます。８９３１！ハクサイって覚えてくださーい！iPhoneのパスワードロック、８９３１！ハクサイって覚えてくださーい！そう、すべてをさらけ出したこの俺は、サンシャイーン！いーけ、ざーき！イエエェェェイ！！
SUCCESS_WORD := $(shell echo $(SUCCESS_WORDS) | tr ' ' '\n' | awk 'BEGIN{srand();}{a[NR]=$$0}END{print a[int(rand()*NR+1)]}')
FAIL_WORDS := テスト失敗 チュピチュピチャパチャパドゥビドゥビダバダバマチコミドゥビドゥビドゥンドゥンドゥン！ 何の成果も得られませんでしたー ジョーダンじゃない！ なんて日だ！ それってあなたの感想ですよね？ 何しとんねん！ 俺はわかってたけどね ひろきくん じゅげむじゅげむごこうのすりきれかいじゃりすいぎょのすいぎょうまつうんらいまつふうらいまつくうねるところにすむところやぶらこうじのぶらこうじパイポパイポパイポのシューリンガンシューリンガンのグーリンダイグーリンダイのポンポコピーのポンポコナーのちょうきゅうめいのちょうすけ

FAIL_WORD := $(shell echo $(FAIL_WORDS) | tr ' ' '\n' | awk 'BEGIN{srand();}{a[NR]=$$0}END{print a[int(rand()*NR+1)]}')

prepare:
	docker-compose up -d
	cd frontend && npm install

f-preview:
	cd frontend && npm run build && afplay audio/kidou.mp3
	cd frontend && npm run preview

f-test:
	cd frontend && npm run lint || say -r 1 -v Cellos らららら
	cd frontend && npm run test && afplay audio/happy.mp3 || afplay audio/tigau.mp3

b-test:
	cd backend && ./gradlew ktlintFormat && ./gradlew ktlintCheck || say "[[pbas 300]]$(FAIL_WORD)"
	cd backend && ./gradlew test && say "[[pbas 100]]$(SUCCESS_WORD)" || afplay audio/doushite.mp3

test:
	make b-test
	make f-test && say "[[pbas 100]]$(SUCCESS_WORD)" || say "[[pbas 300]]$(FAIL_WORD)"

preview:
	cd frontend && npm run build
	cp -r frontend/dist/* backend/src/main/resources/static
	cd backend && ./gradlew bootRun

