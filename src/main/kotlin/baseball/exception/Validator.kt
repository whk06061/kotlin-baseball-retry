package baseball.exception

import net.bytebuddy.implementation.bytecode.StackManipulation.Size
import java.lang.IllegalArgumentException

enum class ErrorMessage(val message: String) {
    ILLEGAL_NUMBER("1부터 9사이의 숫자를 입력해주세요."),
    DUPLICATE("중복 없이 입력해주세요."),
    ILLEGAL_SIZE("숫자 세 개를 입력해주세요.")
}

class Validator {

    fun checkPlayerNumber(input: String): List<Int> {
        val numbers = mutableListOf<Int>()
        for (char in input) {
            val number = char.digitToIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.ILLEGAL_NUMBER.message)
            if (number in numbers) throw IllegalArgumentException(ErrorMessage.DUPLICATE.message)
            if ((number < 1) or (number > 9)) throw IllegalArgumentException(ErrorMessage.ILLEGAL_NUMBER.message)
            numbers.add(number)
        }
        if (numbers.size != SIZE) throw IllegalArgumentException(ErrorMessage.ILLEGAL_SIZE.message)
        return numbers
    }

    companion object {
        const val SIZE = 3
    }
}