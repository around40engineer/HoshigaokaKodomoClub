package com.around40engineer.backend

import org.springframework.stereotype.Service

interface MemoService {
    fun getMemos(): ResGetMemos
    fun saveMemo(memo: String)
}

@Service
class MemoServiceImpl(val repository:MemoRepository) : MemoService {
    override fun getMemos(): ResGetMemos {
        return repository
            .findAll()
            .map { it.memo }
            .let { ResGetMemos(it) }
    }

    override fun saveMemo(memo: String) {
        repository.save(MemoEntity(memo = memo))
    }
}