package com.fh.joanneum.mindmirror.model

object ConventionalSession {
    private var emotions = mutableListOf<String>()

    fun getEmotions(): List<String> {
        return emotions
    }

    fun setEmotions(emotion: String) {
        if (!emotions.contains(emotion)) {
            emotions.add(emotion)
        } else {
            emotions.remove(emotion)
        }
    }

    fun emotionsToString(): String {
        var emotionsAsString = ""
        for (emotion in emotions) {
            emotionsAsString = emotionsAsString + emotion + ", "
        }
        return emotionsAsString.dropLast(2)
    }

    fun clear() {
        emotions.clear()
    }
}