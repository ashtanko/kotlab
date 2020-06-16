package dev.shtanko.algorithms.own

class ByteBuffer(private val message: (bytes: ByteArray) -> Unit) {

    private var buffer: MutableMap<Byte, MutableList<Byte>> = hashMapOf()

    /**
     * Consume and store the chunks in [buffer]
     * Empty the [buffer] when chunk is last
     */
    fun execute(chunks: ByteArray) {

        val pair = Pair(chunks[0], chunks[1])

        if (buffer.containsKey(pair.second)) {
            buffer[pair.second]?.addAll(parseChunk(chunks))
            check(pair.second, pair.first)
        } else {
            buffer[pair.second] = parseChunk(chunks)
            check(pair.second, pair.first)
        }
    }

    /**
     * Check the chunk in the [buffer] is last
     * Call the [message] and remove chunks from [buffer]
     */
    private fun check(id: Byte, position: Byte) {
        if (position == 1.toByte()) {
            buffer[id]?.toByteArray()?.let {
                message.invoke(it)
            }
            buffer.remove(id)
        }
    }

    /**
     * Deletes two first bytes of chunk keeping the data plain
     */
    private fun parseChunk(chunk: ByteArray): MutableList<Byte> {
        return chunk.copyOfRange(2, chunk.size).toMutableList()
    }
}
