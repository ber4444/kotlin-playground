package StacksAndQueuesCtCi

import java.util.*

class StackWithMin : Stack<Int>() {
	var s2 = Stack<Int>()

	override fun push(value: Int): Int {
		if (value <= min()) {
			s2.push(value)
		}
		return super.push(value)
	}

	override fun pop(): Int? {
		val value = super.pop()
		if (value == min()) {
			s2.pop()
		}
		return value
	}

	// O(1) time for returning min value in stack 
	fun min(): Int {
		return if (s2.isEmpty()) {
			Int.MAX_VALUE
		} else {
			s2.peek()
		}
	}
}

val stack = StackWithMin()
stack.push(5)
stack.push(3)
stack.push(2)
stack.push(6)
println(stack.min())
stack.pop()
stack.pop()
println(stack.min())