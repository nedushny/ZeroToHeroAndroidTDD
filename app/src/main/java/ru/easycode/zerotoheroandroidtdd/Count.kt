package ru.easycode.zerotoheroandroidtdd

/**
 * Created by nedushny on 13.11.2023
 */
interface Count {
    fun initial(number: String): UiState
    fun increment(number: String): UiState
    fun decrement(number: String): UiState

    class Base(
        private val step: Int,
        private val max: Int,
        private val min: Int,
    ) : Count {

        init {
            if (step < 1)
                throw IllegalStateException("step should be positive, but was $step")

            if (max < 1)
                throw IllegalStateException("max should be positive, but was $max")

            if (max < step)
                throw IllegalStateException("max should be more than step")

            if (max < min)
                throw IllegalStateException("max should be more than min")
        }

        override fun initial(number: String): UiState {
            val digits = number.toInt()
            return when (digits) {
                max -> UiState.Max(number)
                min -> UiState.Min(number)
                else -> UiState.Base(number)
            }
        }

        override fun increment(number: String): UiState {
            val digits = number.toInt()
            val result = digits + step
            val nextIncrement = result + step
            return if (nextIncrement <= max)
                UiState.Base(result.toString())
            else UiState.Max(result.toString())
        }

        override fun decrement(number: String): UiState {
            val digits = number.toInt()
            val result = digits - step
            val nextDecrement = result - step
            return if (nextDecrement >= min)
                UiState.Base(result.toString())
            else UiState.Min(result.toString())
        }
    }
}