package com.around40engineer.backend

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class MemoController(val service: MemoService) {
    @GetMapping("/memos")
    fun getMemos(): ResGetMemos {
        return service.getMemos()
    }

    @PostMapping("/save")
    fun saveMemo(
        @RequestBody data: ReqSaveMemo
    ){
        service.saveMemo(data.memo)
    }
}