<div id="top"></div>

## 使用技術一覧

<!-- シールド一覧 -->
<!-- 該当するプロジェクトの中から任意のものを選ぶ-->
<p style="display: inline">
  <!-- フロントエンドの言語一覧 -->
  <img src="https://img.shields.io/badge/TypeScript-007ACC?style=for-the-badge&logo=typescript&logoColor=white" alt="typescript">
  <!-- フロントエンドのフレームワーク一覧 -->
<!--   <img src="https://img.shields.io/badge/CSS-239120?&style=for-the-badge&logo=css3&logoColor=white"> -->
  <img src="https://img.shields.io/badge/Node.js-43853D?style=for-the-badge&logo=node.js&logoColor=white" alt="node">
<!--   <img src="https://img.shields.io/badge/SASS-hotpink.svg?style=for-the-badge&logo=SASS&logoColor=white"> -->
  <img src="https://img.shields.io/badge/vite-%23646CFF.svg?style=for-the-badge&logo=vite&logoColor=white" alt="vite">
  <img src="https://img.shields.io/badge/-React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB" alt="react">
<!--   <img src="https://img.shields.io/badge/Redux-593D88?style=for-the-badge&logo=redux&logoColor=white"> -->
  
  <!-- バックエンドの言語一覧 -->
  <img src="https://img.shields.io/badge/Kotlin-0095D5?&style=for-the-badge&logo=kotlin&logoColor=white" alt="kotlin">
  <!-- バックエンドのフレームワーク一覧 -->
  <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="spring">
  
  <!-- ミドルウェア一覧 -->
  <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" alt="postgresql">
<!--   <img src="https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white"> -->
<!--   <img src="https://img.shields.io/badge/Amazon%20DynamoDB-4053D6?style=for-the-badge&logo=Amazon%20DynamoDB&logoColor=white"> -->
  <img src="https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white" alt="gradle">
  
  <!-- インフラ一覧 -->
  <img src="https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white" alt="docker">
<!--   <img src="https://img.shields.io/badge/kubernetes-%23326ce5.svg?style=for-the-badge&logo=kubernetes&logoColor=white"> -->
<!--   <img src="https://img.shields.io/badge/Amazon_AWS-232F3E?style=for-the-badge&logo=amazon-aws&logoColor=white"> -->
<!--   <img src="https://img.shields.io/badge/firebase-a08021?style=for-the-badge&logo=firebase&logoColor=ffcd34"> -->
<!--   <img src="https://img.shields.io/badge/Google_Cloud-4285F4?style=for-the-badge&logo=google-cloud&logoColor=white"> -->
<!--   <img src="https://img.shields.io/badge/terraform-%235835CC.svg?style=for-the-badge&logo=terraform&logoColor=white"> -->
</p>

## 目次

1. [プロジェクトについて](#プロジェクトについて)
2. [環境](#環境)
3. [ディレクトリ構成](#ディレクトリ構成)
4. [開発環境構築](#開発環境構築)
5. [トラブルシューティング](#トラブルシューティング)

<!-- READMEの作成方法のドキュメントのリンク -->
<!-- <br />  -->
<!-- <div align="right">  -->
<!--     <a href="READMEの作成方法のリンク"><strong>READMEの作成方法 »</strong></a> -->
<!-- </div> -->
<!-- <br />  -->
<!-- Dockerfileのドキュメントのリンク-->
<!-- <div align="right">
    <a href="Dockerfileの詳細リンク"><strong>Dockerfileの詳細 »</strong></a>
</div>
<br /> -->
<!-- プロジェクト名を記載 -->

## vite-and-springboot-web-app-template

Webアプリ用のテンプレートリポジトリ

<!-- プロジェクトについて -->

## プロジェクトについて

デモとして簡単なTodoアプリを提供します。</br>
フロントエンドのフレームワークとしてVite(React+Typescript)を使用し、バックエンドのフレームワークとしてSpringBoot(Kotlin)を使用しています。</br>
Postgresqlをデータベースとして使用しています。ローカル開発環境としてDockerを使用してデータベースを立ち上げています。</br>
このテンプレートを使うことで一般的なWebアプリの開発に必要な環境をすぐに構築することができます。</br>


<!-- プロジェクトの概要を記載　-->
<!--     <p align="left"> -->
<!--     <br /> -->
<!-- プロジェクト詳細にBacklogのWikiのリンク -->
<!--     <a href="Backlogのwikiリンク"><strong>プロジェクト詳細 »</strong></a> -->
<!--     <br /> -->
<!--     <br />  -->

<p>(<a href="#top">トップへ</a>)</p>

## 環境

<!-- 言語、フレームワーク、ミドルウェア、インフラの一覧とバージョンを記載 -->

| 言語・フレームワーク  | バージョン  |
|-------------|--------|
| Node.js     | 22.4.1 |
| Typescript  | 5.2.2  |
| Vite        | 5.3.4  |
| Java        | 21.0.4 |
| Spring Boot | 3.3.2  |
| Postgresql  | 15.3   |

その他のパッケージのバージョンは build.gradle.kts と package.json を参照してください

<p>(<a href="#top">トップへ</a>)</p>

## ディレクトリ構成

<!-- Treeコマンドを使ってディレクトリ構成を記載 -->
<pre>
.
├── backend
│   ├── .gradle
│   ├── build
│   ├── gradle
│   ├── src
│   │   ├── main
│   │   │   └── kotlin
│   │   │       └── com
│   │   │           └── example
│   │   │               └── backend
│   │   │                   ├── BootApplication.kt
│   │   │                   ├── MemoController.kt
│   │   │                   ├── MemoRepository.kt
│   │   │                   ├── MemoService.kt
│   │   │                   ├── MemoEntity.kt
│   │   │                   ├── ReqSaveMemo.kt
│   │   │                   └── ResGetMemo.kt
│   │   └── test
│   │       └── kotlin
│   │           └── com
│   │               └── example
│   │                   └── backend
│   │                       ├── controller
│   │                       ├── dto
│   │                       ├── entity
│   │                       ├── repository
│   │                       └── service
│   ├── .gitignore
│   ├── build.gradle.kts
│   ├── gradlew
│   ├── gradlew.bat
│   ├── HELP.md
│   └── settings.gradle.kts
│
├── frontend
│   ├── .gitignore
│   ├── README.md
│   ├── __test__
│   ├── components
│   ├── features
│   ├── next-env.d.ts
│   ├── package-lock.json
│   ├── package.json
│   ├── pages
│   ├── postcss.config.js
│   ├── public
│   ├── styles
│   ├── tailwind.config.js
│   └── tsconfig.json
├── .env
├── .gitignore
├── Makefile
├── README.md
└── docker-compose.yml
</pre>

<p>(<a href="#top">トップへ</a>)</p>

## 開発環境構築

<!-- コンテナの作成方法、パッケージのインストール方法など、開発環境構築に必要な情報を記載 -->

### コンテナの作成と起動

.env ファイルを以下の環境変数例と[環境変数の一覧](#環境変数の一覧)を元に作成

.envは現在使ってません。
必要に応じて作成してください。

[//]: # (MYSQL_ROOT_PASSWORD=root)

[//]: # (MYSQL_DATABASE=django-db)

[//]: # (MYSQL_USER=django)

[//]: # (MYSQL_PASSWORD=django)

[//]: # (MYSQL_HOST=db)

[//]: # (MYSQL_PORT=3306)

[//]: # (SECRET_KEY=django)

[//]: # (DJANGO_SETTINGS_MODULE=project.settings.local)

[//]: # (ALLOWED_HOSTS=localhost)

[//]: # (MYSQL_ROOT_PASSWORD=root)

[//]: # (MYSQL_DATABASE=django-db)

[//]: # (MYSQL_USER=django)

[//]: # (MYSQL_PASSWORD=django)

[//]: # (MYSQL_HOST=db)

[//]: # (MYSQL_PORT=3306)

[//]: # (SECRET_KEY=django)

[//]: # (DJANGO_SETTINGS_MODULE=project.settings.local)


(必要に応じて.env ファイルを作成後)</br>
以下のコマンドで開発環境を構築

```
make prepare
```

開発環境が構築できたら以下のコマンドでアプリを起動

```
make preview
```

### 動作確認

http://localhost:8080 にアクセスできるか確認
アクセスできたら成功

### コンテナの停止

以下のコマンドでコンテナを停止することができます

```
make down
```

### 環境変数の一覧

| 変数名                    | 役割                          | デフォルト値                             | DEV 環境での値            |
|------------------------|-----------------------------|------------------------------------|----------------------|
| MYSQL_ROOT_PASSWORD    | MySQL のルートパスワード（Docker で使用） | root                               |                      |
| MYSQL_DATABASE         | MySQL のデータベース名（Docker で使用）  | django-db                          |                      |
| MYSQL_USER             | MySQL のユーザ名（Docker で使用）     | django                             |                      |
| MYSQL_PASSWORD         | MySQL のパスワード（Docker で使用）    | django                             |                      |
| MYSQL_HOST             | MySQL のホスト名（Docker で使用）     | db                                 |                      |
| MYSQL_PORT             | MySQL のポート番号（Docker で使用）    | 3306                               |                      |
| SECRET_KEY             | Django のシークレットキー            | secretkey                          | 他者に推測されないランダムな値にすること |
| ALLOWED_HOSTS          | リクエストを許可するホスト名              | localhost 127.0.0.1 [::1] back web | フロントのホスト名            |
| DEBUG                  | デバッグモードの切り替え                | True                               | False                |
| TRUSTED_ORIGINS        | CORS で許可するオリジン              | http://localhost                   |                      |
| DJANGO_SETTINGS_MODULE | Django アプリケーションの設定モジュール     | project.settings.local             | project.settings.dev |

### コマンド一覧

| Make           | 実行する処理                            | 元のコマンド                                              |
|----------------|-----------------------------------|-----------------------------------------------------|
| make prepare   | node_modules のインストール、コンテナの起動      | cd frontend && npm install</br>docker-compose up -d |
| make f-test    | フロントエンドのテストを実行                    | cd frontend && npm run test                         |
| make b-test    | バックエンドのテストを実行                     | cd backend &&  ./gradle test                        |
| make test      | フロントエンドとバックエンドのテストを実行             | make f-test && make b-test                          |
| make f-preview | フロントエンドを起動（localhost:5173）        | cd frontend && npm run test                         |
| make preview   | フロントエンドとバックエンドを起動(localhost:8080) | cd frontend && npm run build</br>cd frontend &&     |
| make down      | 立ち上げたコンテナを停止する                    | docker-compose down                                 |


<!-- ### リモートデバッグの方法

リモートデバッグ を使用する際は以下の url を参考に設定してください<br>
[Django のコンテナへリモートデバッグしよう！](https://qiita.com/shun198/items/9e4fcb4479385217c323)-->

## トラブルシューティング

### .env: no such file or directory

.env ファイルがないので環境変数の一覧を参考に作成しましょう

### docker daemon is not running

Docker Desktop が起動できていないので起動させましょう

### Ports are not available: address already in use

別のコンテナもしくはローカル上ですでに使っているポートがある可能性があります
<br>
下記記事を参考にしてください
<br>
[コンテナ起動時に Ports are not available: address already in use が出た時の対処法について](https://qiita.com/shun198/items/ab6eca4bbe4d065abb8f)

### Module not found

make build

を実行して Docker image を更新してください

<p>(<a href="#top">トップへ</a>)</p>
