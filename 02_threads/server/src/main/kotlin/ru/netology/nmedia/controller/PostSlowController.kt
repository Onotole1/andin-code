package ru.netology.nmedia.controller

import org.springframework.web.bind.annotation.*
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.service.PostService

const val delay = 5000L

@RestController
@RequestMapping("/api/slow/posts")
class PostSlowController(private val service: PostService) {
    @GetMapping
    fun getAll(): List<Post> {
        Thread.sleep(delay)
        return service.getAll()
    }

    @GetMapping("/{id}")
    fun getAll(@PathVariable id: Long) {
        Thread.sleep(delay)
        service.getById(id)
    }

    @PostMapping
    fun save(@RequestBody dto: Post) {
        Thread.sleep(delay)
        service.save(dto)
    }

    @DeleteMapping("/{id}")
    fun removeById(@PathVariable id: Long) {
        Thread.sleep(delay)
        service.removeById(id)
    }

    @PostMapping("/{id}/likes")
    fun likeById(@PathVariable id: Long): Post {
        Thread.sleep(delay)
        return service.likeById(id)
    }

    @DeleteMapping("/{id}/likes")
    fun unlikeById(@PathVariable id: Long): Post {
        Thread.sleep(delay)
        return service.unlikeById(id)
    }
}