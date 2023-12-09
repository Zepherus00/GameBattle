package com.example.gamebattleapp

class Stack<T> {
    private val items: MutableList<T> = mutableListOf()

    fun push(item: T) = items.add(0, item)

    fun pop(): T? {
        val element: T? = items.firstOrNull()
        items.removeFirstOrNull()
        return element
    }

    fun isEmpty(): Boolean = items.isEmpty()

    override fun toString() = this.items.toString()
}