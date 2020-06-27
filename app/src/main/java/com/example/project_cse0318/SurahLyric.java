package com.example.project_cse0318;

public class SurahLyric {

    private String A_Lyric[] = new String[100];
    private String B_Lyric[] = new String[100];
    private String surahName[] = new String[100];

    SurahLyric(){
        init();
    }

    private void init(){
        B_Lyric[0] = "যাবতীয় প্রশংসা আল্লাহ তাআলার যিনি সকল সৃষ্টি জগতের পালনকর্তা। যিনি নিতান্ত মেহেরবান ও দয়ালু। যিনি বিচার দিনের মালিক। আমরা একমাত্র তোমারই ইবাদত করি এবং শুধুমাত্র তোমারই সাহায্য প্রার্থনা করি। আমাদেরকে সরল পথ দেখাও, সে সমস্ত লোকের পথ, যাদেরকে তুমি নেয়ামত দান করেছ। তাদের পথ নয়, যাদের প্রতি তোমার গজব নাযিল হয়েছে এবং যারা পথভ্রষ্ট হয়েছে।";
        B_Lyric[1] = "(১) আপনি কি শোনেন নি, আপনার প্রভু হস্তীওয়ালাদের সাথে কিরূপ আচরণ করেছিলেন? (২) তিনি কি তাদের চক্রান্ত নস্যাৎ করে দেননি? (৩) তিনি তাদের উপরে প্রেরণ করেছিলেন ঝাঁকে ঝাঁকে পাখি (৪) যারা তাদের উপরে নিক্ষেপ করেছিল মেটেল পাথরের কংকর (৫) অতঃপর তিনি তাদের করে দেন ভক্ষিত তৃণসদৃশ।";
        B_Lyric[2] = "(১) কুরায়েশদের আসক্তির কারণে (২) আসক্তির কারণে তাদের শীত ও গ্রীষ্মকালীন সফরের (৩) অতএব তারা যেন ইবাদত করে এই গৃহের মালিকের (৪) যিনি তাদেরকে ক্ষুধায় অন্ন দান করেছেন এবং ভীতি হ’তে নিরাপদ করেছেন।";
        B_Lyric[3] = "(১) আপনি কি দেখেছেন তাকে, যে বিচার দিবসকে মিথ্যা বলে? (২) সে হ’ল ঐ ব্যক্তি, যে ইয়াতীমকে গলা ধাক্কা দেয় (৩) এবং মিসকীনকে খাদ্য দানে উৎসাহিত করে না (৪) অতঃপর দুর্ভোগ ঐ সব মুছল্লীর জন্য (৫) যারা তাদের ছালাত থেকে উদাসীন (৬) যারা লোকদেরকে দেখায় (৭) এবং নিত্য ব্যবহার্য বস্ত্ত দানে বিরত থাকে।";
        B_Lyric[4] = "(১) নিশ্চয়ই আমরা আপনাকে ‘কাওছার’ দান করেছি (২) অতএব আপনার প্রভুর উদ্দেশ্যে ছালাত আদায় করুন ও কুরবানী করুন (৩) নিশ্চয়ই আপনার শত্রুই নির্বংশ।";
        B_Lyric[5] = "বলুন, হে কাফেরকূল, আমি এবাদত করিনা, তোমরা যার এবাদত কর। এবং তোমরাও এবাদতকারী নও, যার এবাদত আমি করি এবং আমি এবাদতকারী নই, যার এবাদত তোমরা কর। তোমরা এবাদতকারী নও, যার এবাদত আমি করি। তোমাদের কর্ম ও কর্মফল তোমাদের জন্যে এবং আমার কর্ম ও কর্মফল আমার জন্যে।";
        B_Lyric[6] = "যখন আসবে আল্লাহর সাহায্য ও বিজয় এবং আপনি মানুষকে দলে দলে আল্লাহর দ্বীনে প্রবেশ করতে দেখবেন, তখন আপনি আপনার পালনকর্তার পবিত্রতা বর্ণনা করুন এবং তাঁর কাছে ক্ষমা প্রার্থনা করুন। নিশ্চয় তিনি ক্ষমাকারী।";
        B_Lyric[7] = "বলুন, আমি আশ্রয় গ্রহণ করছি প্রভাতের পালনকর্তার, তিনি যা সৃষ্টি করেছেন, তার অনিষ্ট থেকে, অন্ধকার রাত্রির অনিষ্ট থেকে, যখন তা সমাগত হয়, গ্রন্থিতে ফুঁৎকার দিয়ে জাদুকারিনীদের অনিষ্ট থেকে এবং হিংসুকের অনিষ্ট থেকে যখন সে হিংসা করে।";
        B_Lyric[8] = "\n" +
                "বলুন, তিনি আল্লাহ, এক,\n" +
                "আল্লাহ অমুখাপেক্ষী,\n" +
                "তিনি কাউকে জন্ম দেননি এবং কেউ তাকে জন্ম দেয়নি\n" +
                "এবং তার সমতুল্য কেউ নেই।";
        B_Lyric[9] = "পরম করুণাময় অতি দয়ালু আল্লাহ নামে শুরু করছি।\n" +
                "বলুন, আমি আশ্রয় গ্রহণ করছি প্রভাতের পালনকর্তার,\n" +
                "তিনি যা সৃষ্টি করেছেন, তার অনিষ্ট থেকে,\n" +
                "অন্ধকার রাত্রির অনিষ্ট থেকে, যখন তা সমাগত হয়,\n" +
                "গ্রন্থিতে ফুঁৎকার দিয়ে জাদুকারিণীদের অনিষ্ট থেকে\n" +
                "এবং হিংসুকের অনিষ্ট থেকে যখন সে হিংসা করে।";
        B_Lyric[10] = "১।বল,‘আমি আশ্রয় চাই মানুষের রব,\n" +
                "২। মানুষের অধিপতি,\n" +
                "৩। মানুষের ইলাহ-এর কাছে,\n" +
                "৪। কুমন্ত্রণাদাতার অনিষ্ট থেকে,যে দ্রুত আত্ম গোপন করে।\n" +
                "৫। যে মানুষের মনে কুমন্ত্রাণা দেয়\n" +
                "৬। জিন ও মানুষ থেকে।";


        A_Lyric[0] = "\n" +
                "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّح۪يمِ\n" +
                "١﴾ اَلْحَمْدُ لِلّٰهِ رَبِّ الْعَالَم۪ينَۙ ﴿٢﴾ اَلرَّحْمٰنِ الرَّح۪يمِۙ ﴿٣﴾ مَالِكِ يَوْمِ الدّ۪ينِۜ ﴿٤﴾ اِيَّاكَ نَعْبُدُ وَاِيَّاكَ نَسْتَع۪ينُۜ ﴿٥﴾ اِهْدِنَا الصِّرَاطَ الْمُسْتَق۪يمَۙ ﴿٦﴾ صِرَاطَ الَّذ۪ينَ اَنْعَمْتَ عَلَيْهِمْۙ غَيْرِ الْمَغْضُوبِ عَلَيْهِمْ وَلَا الضَّٓالّ۪ينَ ﴿٧";
        A_Lyric[1] = "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّح۪يمَِلَمْ تَرَ كَيْفَ فَعَلَ رَبُّكَ بِاَصْحَابِ الْف۪يلِۜ ﴿١﴾ اَلَمْ يَجْعَلْ كَيْدَهُمْ ف۪ي تَضْل۪يلٍۙ ﴿٢﴾ وَاَرْسَلَ عَلَيْهِمْ طَيْراً اَبَاب۪يلَۙ ﴿٣﴾ تَرْم۪يهِمْ بِحِجَارَةٍ مِنْ سِجّ۪يلٍۖۙ ﴿٤﴾ فَجَعَلَهُمْ كَعَصْفٍ مَأْكُولٍ ﴿٥";
        A_Lyric[2] = "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّح۪يمِ\n" +
                "لِا۪يلَافِ قُرَيْشٍۙ ﴿١﴾ ا۪يلَافِهِمْ رِحْلَةَ الشِّتَٓاءِ وَالصَّيْفِۚ ﴿٢﴾ فَلْيَعْبُدُوا رَبَّ هٰذَا الْبَيْتِۙ ﴿٣﴾ اَلَّذ۪ٓي اَطْعَمَهُمْ مِنْ جُوعٍ وَاٰمَنَهُمْ مِنْ خَوْفٍ ﴿٤\n";
        A_Lyric[3] = "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّح۪يمِ\n" +
                "اَرَاَيْتَ الَّذ۪ي يُكَذِّبُ بِالدّ۪ينِۜ ﴿١﴾ فَذٰلِكَ الَّذ۪ي يَدُعُّ الْيَت۪يمَۙ ﴿٢﴾ وَلَا يَحُضُّ عَلٰى طَعَامِ الْمِسْك۪ينِۜ ﴿٣﴾ فَوَيْلٌ لِلْمُصَلّ۪ينَۙ ﴿٤﴾ اَلَّذ۪ينَ هُمْ عَنْ صَلَاتِهِمْ سَاهُونَۙ ﴿٥﴾ اَلَّذ۪ينَ هُمْ يُرَٓاؤُ۫نَۙ ﴿٦﴾ وَيَمْنَعُونَ الْمَاعُونَ ﴿٧\n";
        A_Lyric[4] = "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّح۪يمِ\n" +
                "اِنَّٓا اَعْطَيْنَاكَ الْـكَوْثَرَۜ ﴿١﴾ فَصَلِّ لِرَبِّكَ وَانْحَرْۜ ﴿٢﴾ اِنَّ شَانِئَكَ هُوَ الْاَبْتَرُ ﴿٣\n";

        A_Lyric[5] = "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّح۪يمِ\n" +
                "قُلْ يَٓا اَيُّهَا الْـكَافِرُونَۙ ﴿١﴾ لَٓا اَعْبُدُ مَا تَعْبُدُونَۙ ﴿٢﴾ وَلَٓا اَنْتُمْ عَابِدُونَ مَٓا اَعْبُدُۚ ﴿٣﴾ وَلَٓا اَنَا۬ عَابِدٌ مَا عَبَدْتُمْۙ ﴿٤﴾ وَلَٓا اَنْتُمْ عَابِدُونَ مَٓا اَعْبُدُۜ ﴿٥﴾ لَـكُمْ د۪ينُكُمْ وَلِيَ د۪ينِ ﴿٦\n";
        A_Lyric[6] = "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّح۪يمِ\n" +
                "اِذَا جَٓاءَ نَصْرُ اللّٰهِ وَالْفَتْحُۙ ﴿١﴾ وَرَاَيْتَ النَّاسَ يَدْخُلُونَ ف۪ي د۪ينِ اللّٰهِ اَفْوَاجاًۙ ﴿٢﴾ فَسَبِّحْ بِحَمْدِ رَبِّكَ وَاسْتَغْفِرْهُۜ اِنَّهُ كَانَ تَوَّاباً ﴿٣\n";
        A_Lyric[7] = "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّح۪يمِ\n" +
                "تَبَّتْ يَدَٓا اَب۪ي لَهَبٍ وَتَبَّۜ ﴿١﴾ مَٓا اَغْنٰى عَنْهُ مَالُهُ وَمَا كَسَبَۜ ﴿٢﴾ سَيَصْلٰى نَاراً ذَاتَ لَهَبٍۚ ﴿٣﴾ وَامْرَاَتُهُۜ حَمَّالَةَ الْحَطَبِۚ ﴿٤﴾ ف۪ي ج۪يدِهَا حَبْلٌ مِنْ مَسَدٍ ﴿٥";
        A_Lyric[8] = "\n" +
                "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّح۪يمِ\n" +
                "قُلْ هُوَ اللّٰهُ اَحَدٌۚ ﴿١﴾ اَللّٰهُ الصَّمَدُۚ ﴿٢﴾ لَمْ يَلِدْ وَلَمْ يُولَدْۙ ﴿٣﴾ وَلَمْ يَكُنْ لَهُ كُفُواً اَحَدٌ ﴿٤";
        A_Lyric[9] = "\n" +
                "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّح۪يمِ\n" +
                "قُلْ اَعُوذُ بِرَبِّ الْفَلَقِۙ ﴿١﴾ مِنْ شَرِّ مَا خَلَقَۙ ﴿٢﴾ وَمِنْ شَرِّ غَاسِقٍ اِذَا وَقَبَۙ ﴿٣﴾ وَمِنْ شَرِّ النَّفَّاثَاتِ فِي الْعُقَدِۙ ﴿٤﴾ وَمِنْ شَرِّ حَاسِدٍ اِذَا حَسَدَ ﴿";
        A_Lyric[10] = "\n" +
                "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّح۪يمِ\n" +
                "قُلْ اَعُوذُ بِرَبِّ النَّاسِۙ ﴿١﴾ مَلِكِ النَّاسِۙ ﴿٢﴾ اِلٰهِ النَّاسِۙ ﴿٣﴾ مِنْ شَرِّ الْوَسْوَاسِ الْخَنَّاسِۙ ﴿٤﴾ اَلَّذ۪ي يُوَسْوِسُ ف۪ي صُدُورِ النَّاسِۙ ﴿٥﴾ مِنَ الْجِنَّةِ وَالنَّاسِ ﴿٦";


        surahName[0] = "Al-Fatihah";
        surahName[1] = "Al-Fiyl";
        surahName[2] = "Quraysh";
        surahName[3] = "Al-Maa‘oun";
        surahName[4] = "Al-Kawthar";
        surahName[5] = "Al-Kaafiroun";
        surahName[6] = "An-Nasr";
        surahName[7] = "Al-Masad";
        surahName[8] = "Al-Ikhlaas";
        surahName[9] = "Al-Falaq";
        surahName[10] = "An-Naas";
    }

    public String getArabicLyric(int index){
        return A_Lyric[index];
    }

    public String getBanglaLyric(int index){
        return B_Lyric[index];
    }

    public String getSurahName(int index){
        return surahName[index];
    }
}
