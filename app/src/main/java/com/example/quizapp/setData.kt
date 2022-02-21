package com.example.quizapp

object setData {
    const val name:String="NAME"
    const val score:String=""
    fun getQuestion():ArrayList<questionData>{
        var que:ArrayList<questionData> = ArrayList()
        var question1=questionData(
            1,
            "what is capital of India ?",

            "Uttar Pradesh",
            "Madhya Pradesh",
            "Kanpur",
            "New Delhi",
            4
        )
        var question2 = questionData(
            2,
            "Who was the first Indian woman in Space ?",

            "Kalpana Chawla",
            "Sunita Williams",
            "Koneru Humpy",
            "None of the above",
            1
        )
        var question3 = questionData(
            3,
            "Who wrote the Indian National Anthem ?",

            "Bakim Chandra Chatterji",
            "Rabindranath Tagore",
            "Swami Vivekanand",
            "None of the above",
            2
        )
        var question4 = questionData(
            4,
            "Who was the first President of India ?",

            "Abdul Kalam",
            "Lal Bahadur Shastri",
            "Dr. Rajendra Prasad",
            "Zakir Hussain",
            3
        )

        var question5 = questionData(
            5,
            "Who built the Jama Masjid ?",

            "Jahangir",
            "Akbar",
            "Imam Bukhari",
            "Shah Jahan",
            4
        )
        que.add(0,question1)
        que.add(1,question2)
        que.add(2,question3)
        que.add(3,question4)
        que.add(4,question5)
        return que
    }


}