package com.around40engineer.backend

import com.linecorp.bot.spring.boot.handler.annotation.EventMapping
import com.linecorp.bot.spring.boot.handler.annotation.LineMessageHandler
import com.linecorp.bot.webhook.model.Event
import com.linecorp.bot.webhook.model.FollowEvent
import com.linecorp.bot.webhook.model.MessageEvent
import com.linecorp.bot.webhook.model.TextMessageContent
import org.slf4j.LoggerFactory

@LineMessageHandler
class MessageController (val service: MessageService) {
    private val log = LoggerFactory.getLogger(MessageController::class.java)
    @EventMapping
    fun handleFollow(event: FollowEvent?){
        if (event != null) {
            service.follow(event)
        }
    }

    @EventMapping
    fun handleMessage(event: MessageEvent?, textMessageContent: TextMessageContent){
        if (event != null) {
            println(textMessageContent.text)
            service.talk(event, textMessageContent)
        }
    }

    @EventMapping
    fun handleDefaultMessageEvent(event: Event) {
        log.info("event: $event")
    }
}