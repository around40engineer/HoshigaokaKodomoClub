package com.around40engineer.backend

import com.linecorp.bot.messaging.client.MessagingApiClient
import com.linecorp.bot.messaging.model.Message
import com.linecorp.bot.messaging.model.ReplyMessageRequest
import com.linecorp.bot.messaging.model.TextMessage
import com.linecorp.bot.webhook.model.FollowEvent
import com.linecorp.bot.webhook.model.MessageEvent
import com.linecorp.bot.webhook.model.TextMessageContent
import org.springframework.stereotype.Service

interface MessageService {
    fun follow(event: FollowEvent)
    fun talk(event: MessageEvent, textMessageContent: TextMessageContent)
}

@Service
class MessageServiceImpl(
    val messagingApiClient: MessagingApiClient
) : MessageService {
    override fun follow(event: FollowEvent) {
        val followMessage = listOf(
            TextMessage("星ヶ丘子どもクラブのメール転送用Botです。このBotへ送られたメッセージを指定のe-mailへ転送します。メッセージの転送先の登録と削除もできます。")
        )
        messagingApiClient.replyMessage(ReplyMessageRequest(event.replyToken, followMessage, false))
    }

    override fun talk(event: MessageEvent, textMessageContent: TextMessageContent) {
        println("talked")
    }
}
