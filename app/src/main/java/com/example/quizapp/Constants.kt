package com.example.quizapp

object Constants {

    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_answer"

    fun getQuestions():ArrayList<Question>{
        val questionList=ArrayList<Question>()

        val que1 = Question(
            1,
            "What country does this flag belong?",
            R.drawable.ic_flag_of_argentina,
            "Belgium",
            "Argentina",
            "Spain",
            "Russia",
            2
        )
        questionList.add(que1)
        val que2 = Question(
            2,
            "What country does this flag belong?",
            R.drawable.ic_flag_of_fiji,
            "Fiji",
            "Argentina",
            "India",
            "Russia",
            1
        )
        questionList.add(que2)
        val que3 = Question(
            3,
            "What country does this flag belong?",
            R.drawable.ic_flag_of_india,
            "Pakistan",
            "India",
            "USA",
            "Italy",
            2
        )
        questionList.add(que3)
        val que4 = Question(
            4,
            "What country does this flag belong?",
            R.drawable.ic_flag_of_australia,
            "Belgium",
            "Argentina",
            "Australia",
            "Russia",
            3
        )
        questionList.add(que4)
        val que5 = Question(
            5,
            "What country does this flag belong?",
            R.drawable.ic_flag_of_belgium,
            "Belgium",
            "Argentina",
            "Germany",
            "Ukraine",
            1
        )
        questionList.add(que5)
        val que6 = Question(
            6,
            "What country does this flag belong?",
            R.drawable.ic_flag_of_denmark,
            "Bangladesh",
            "Argentina",
            "Denmark",
            "India",
            3
        )
        questionList.add(que6)
        val que7 = Question(
            7,
            "What country does this flag belong?",
            R.drawable.ic_flag_of_kuwait,
            "Kenya",
            "Zimbabwe",
            "Kuwait",
            "Mexico",
            3
        )
        questionList.add(que7)
        val que8 = Question(
            8,
            "What country does this flag belong?",
            R.drawable.ic_flag_of_new_zealand,
            "England",
            "Australia",
            "Spain",
            "New Zealand",
            4
        )
        questionList.add(que8)
        val que9 = Question(
            9,
            "What country does this flag belong?",
            R.drawable.ic_flag_of_brazil,
            "Brazil",
            "Italy",
            "Greenland",
            "Japan",
            1
        )
        questionList.add(que9)
        return questionList
    }
}