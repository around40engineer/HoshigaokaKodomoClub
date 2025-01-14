package com.around40engineer.backend

import com.linecorp.bot.messaging.client.MessagingApiClient
import com.linecorp.bot.messaging.model.ReplyMessageRequest
import com.linecorp.bot.messaging.model.TextMessage
import com.linecorp.bot.webhook.model.FollowEvent
import com.linecorp.bot.webhook.model.MessageEvent
import com.linecorp.bot.webhook.model.TextMessageContent
import org.springframework.stereotype.Service
import java.util.regex.Pattern

interface MessageService {
    fun follow(event: FollowEvent)
    fun handleMessage(event: MessageEvent, textMessageContent: TextMessageContent)
}

@Service
class MessageServiceImpl(
    val messagingApiClient: MessagingApiClient,
    val userRepository: UserRepository
) : MessageService {
    override fun follow(event: FollowEvent) {
        println("followEvent: $event")
    }
    val emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
    override fun handleMessage(event: MessageEvent, textMessageContent: TextMessageContent) {
        var userEntity: UserEntity
        try {
            userEntity = userRepository.findById(event.source.userId()).get()
        } catch (e: Exception) {
            userEntity = UserEntity(event.source.userId(), "normal")
            userRepository.save(userEntity)
        }
        if(textMessageContent.text == "***転送先登録***"){
            this.prepareToRegister(event, textMessageContent)
        }else if(textMessageContent.text == "***転送先削除***"){
            this.prepareToDelete(event, textMessageContent)
        }else if(textMessageContent.text == "***転送先確認***"){
            this.getForwardingDestination(event, textMessageContent)
        }else{
            if(userEntity.status == "register"){
                if (emailPattern.matcher(textMessageContent.text).matches()) {
//                    forwardingDestinationRepository.save(FordingDestination(textMessageContent.text))
                    userRepository.save(UserEntity(event.source.userId(), "normal"))
                    val successMessage = listOf(
                        TextMessage("${textMessageContent.text}\nを転送先に登録しました。")
                    )
                    messagingApiClient.replyMessage(ReplyMessageRequest(event.replyToken, successMessage, false))
                } else {
                    val errorMessage = listOf(
                        TextMessage("無効なメールアドレスです。もう一度入力してください。")
                    )
                    messagingApiClient.replyMessage(ReplyMessageRequest(event.replyToken, errorMessage, false))
                }
            }else if(userEntity.status == "delete"){
                if (emailPattern.matcher(textMessageContent.text).matches()) {
//                    forwardingDestinationRepository.save(FordingDestination(textMessageContent.text))
                    userRepository.save(UserEntity(event.source.userId(), "normal"))
                    val successMessage = listOf(
                        TextMessage("${textMessageContent.text}\nの転送を解除しました。")
                    )
                    messagingApiClient.replyMessage(ReplyMessageRequest(event.replyToken, successMessage, false))
                } else {
                    val errorMessage = listOf(
                        TextMessage("無効なメールアドレスです。もう一度入力してください。")
                    )
                    messagingApiClient.replyMessage(ReplyMessageRequest(event.replyToken, errorMessage, false))
                }
            }else{
                this.forwardToMail(event, textMessageContent)
            }
        }
    }

    private fun prepareToRegister(event: MessageEvent, textMessageContent: TextMessageContent) {
        val followMessage = listOf(
            TextMessage("転送したいメールアドレスを入力してください。")
        )
        messagingApiClient.replyMessage(ReplyMessageRequest(event.replyToken, followMessage, false))
        userRepository.save(UserEntity(event.source.userId(), "register"))
    }

    private fun prepareToDelete(event: MessageEvent, textMessageContent: TextMessageContent) {
        val followMessage = listOf(
            TextMessage("転送設定を解除したいメールアドレスを入力してください。")
        )
        messagingApiClient.replyMessage(ReplyMessageRequest(event.replyToken, followMessage, false))
        userRepository.save(UserEntity(event.source.userId(), "delete"))
    }

    private fun getForwardingDestination(event: MessageEvent, textMessageContent: TextMessageContent) {
        val followMessage = listOf(
            TextMessage("現在、転送設定されているメールアドレスは以下の通りです。\n" +
                    "転送先メールアドレス1\n" +
                    "転送先メールアドレス2\n" +
                    "転送先メールアドレス3\n" +
                    "転送先メールアドレス4\n" +
                    "転送先メールアドレス5\n" +
                    "転送先メールアドレス6\n" +
                    "転送先メールアドレス7\n" +
                    "転送先メールアドレス8\n" +
                    "転送先メールアドレス9\n" +
                    "転送先メールアドレス10\n")
        )
        messagingApiClient.replyMessage(ReplyMessageRequest(event.replyToken, followMessage, false))
    }

    private fun forwardToMail(event: MessageEvent, textMessageContent: TextMessageContent) {
        TODO("Not yet implemented")
    }
}
