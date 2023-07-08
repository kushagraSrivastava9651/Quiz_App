package com.example.myquizapp

object Constants {
    const val USER_NAME:String="user_name"
    const val total_ques:String="Total Question"
    const val total_ans="Total_Answer"
    fun getQuestions():ArrayList<Question>{
        val questionsList=ArrayList<Question>()
            val ques1=Question(
            1,"What country does this flag belong to?",
             R.drawable.india,
                "INDIA","AUSTRALIA","ARGENTINA","RUSSIA",
            1
            )
        val ques2=Question(
            1,"What country does this flag belong to?",
            R.drawable.south_africa,
            "INDIA","AUSTRALIA","SOUTH AFRICA","RUSSIA",
            3
        )
        val ques3=Question(
            1,"What country does this flag belong to?",
            R.drawable.usa,
            "INDIA","AUSTRALIA","ARGENTINA","USA",
            4
        )
        val ques4=Question(
            1,"What country does this flag belong to?",
            R.drawable.brazil,
            "INDIA","BRAZIL","ARGENTINA","USA",
            2
        )
        val ques5=Question(
            1,"What country does this flag belong to?",
            R.drawable.maxico,
            "MEXICO","BRAZIL","ARGENTINA","USA",
            1
        )
        val ques6=Question(
            1,"What country does this flag belong to?",
            R.drawable.canada,
            "MEXICO","CANADA","ARGENTINA","USA",
            2
        )
        val ques7=Question(
            1,"What country does this flag belong to?",
            R.drawable.china,
            "MEXICO","CANADA","CHINA","USA",
            3
        )
        val ques8=Question(
            1,"What country does this flag belong to?",
            R.drawable.algeria,
            "MEXICO","CANADA","ARGENTINA","ALGERIA",
            4
        )



        questionsList.add(ques1)
        questionsList.add(ques2)
        questionsList.add(ques3)
        questionsList.add(ques4)
        questionsList.add(ques5)
        questionsList.add(ques6)
        questionsList.add(ques7)
        questionsList.add(ques8)






        return questionsList
    }
}