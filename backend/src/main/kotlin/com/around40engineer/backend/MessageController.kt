package com.around40engineer.backend

import com.linecorp.bot.spring.boot.handler.annotation.EventMapping
import com.linecorp.bot.spring.boot.handler.annotation.LineMessageHandler
import com.linecorp.bot.webhook.model.FollowEvent
import com.linecorp.bot.webhook.model.MessageEvent
import com.linecorp.bot.webhook.model.TextMessageContent

@LineMessageHandler
class MessageController (val service: MessageService) {
    @EventMapping
    fun handleFollow(event: FollowEvent?){
        if (event != null) {
            service.follow(event)
        }
    }

    @EventMapping
    fun handleMessage(event: MessageEvent?, textMessageContent: TextMessageContent){
        if (event != null) {
            service.talk(event, textMessageContent)
        }
    }
}