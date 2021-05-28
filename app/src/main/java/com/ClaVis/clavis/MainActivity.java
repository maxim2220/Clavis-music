package com.ClaVis.clavis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.ClaVis.clavis.fracments.PianoFragment;
import com.ClaVis.clavis.model.Stats;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String MSG_NAME = "msg_name";
    public static final String TAG = "MyTag";
    public static final String MSG_MODE = "MsgMode";
    public static Integer score = 0;
    public static Integer fails_score = 0;
    private Random random;
    private static Integer[] ids = new Integer[]{R.id.bt1,
            R.id.bt2, R.id.bt3, R.id.bt4, R.id.bt5, R.id.bt6, R.id.bt7};
    private Integer tmp;
    private SharedPreferences preferences;

    public static final ArrayList<Stats> statsList = new ArrayList<>();

    public static Integer[] getIds() {
        return ids;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.Mytobbar);
        setActionBar(toolbar);
        random = new Random();
        tmp = getItemRandom();



        statsList.add(new Stats("Скрипичный ключ", "основная инфа", ""));
        statsList.get(0).getList().add(new Stats("Введение", "Звук как физическое явление возникает от колебаний какоголибо упругого тела - например, струны (у тех инструментов, где\n" +
                "есть струны), воздушного столба (у духовых инструментов, баяна,\n" +
                "аккордеона, органа), голосовых связок у человека. Эти колебания\n" +
                "создают звуковые волны. ч\n" +
                "Звуки бывают музыкальные и шумовые. Для музыкального звука\n" +
                "главное — точная, ясно выраженная высота. Она зависит от частоты\n" +
                "звуковых колебаний: чем чаще колебания, тем звук выше.\n"+
                "Ключ (от лат. clavis) — знак линейной нотации, определяющий звуковысотное значение нот." +
                " Относительно линейки нотоносца, на которую указывает центральный элемент ключа, рассчитываются все другие высотные позиции нот." +
                " Основные типы ключей, принятые в классической пятилинейной тактовой нотации: ключ «соль»," +
                " ключ «фа» и ключ «до».", null, this, R.drawable.a));
        statsList.get(0).getList().add(new Stats("Скрипичный ключ",
                "Скрипичный ключ помещает ноту «соль» первой октавы на вторую линейку нотоносца. Является самым распространённым ключом." +
                        " В скрипичном ключе пишутся ноты для скрипки (отсюда название) и других инструментов с достаточно высоким звучанием."
                        , null, this, R.drawable.w48nots_scripich));
        statsList.add(new Stats("Басовый ключ", "", ""));
        statsList.get(1).getList().add(new Stats("Басовый ключ",
                "Басовый ключ помещает ноту «фа» малой октавы на четвертую линейку нотоносца." +
                        " Второй по распространённости ключ после скрипичного. Этим ключом пользуются инструменты с низким звучанием: виолончель," +
                        " фагот и т. д. "
                , null, this, R.drawable.w48nots_bazzz));
        statsList.get(1).getList().add(new Stats("Применение",
                " В басовом ключе обычно пишется партия левой руки для фортепиано. Вокальная музыка для баса и баритона также пишется обычно в басовом ключе." +
                        " Партия контрабаса, записанная в басовом ключе, исполняется на октаву ниже."
                , null, this, R.drawable.wwwwfkdfskfmd));
        statsList.add(new Stats("", "", ""));

        preferences = getPreferences(Context.MODE_PRIVATE);

    }
    public Integer getItemRandom(){
        return random.nextInt(ids.length);
    }


    public synchronized void click(View v){
        new Thread(()->{
            int id = v.getId();
            if (ids[tmp] == id){
                MediaPlayer mediaPlayer = PlayerSetMusic.setMusic(this, id);
                mediaPlayer.start();
                tmp = getItemRandom();
                score++;
                PianoFragment.setScore(score);
                runOnUiThread(()->{
                    PianoFragment.setImage(MainActivity.this);
                });
            }else {
                fails_score++;
                PianoFragment.setFailScore(fails_score);
            }

            if (score + fails_score == 20) {
                Snackbar.make(v, "Попытки кончились. Результат : " + score, BaseTransientBottomBar.LENGTH_LONG).setAction("Action", null).show();
                boolean navController = NavHostFragment.findNavController(getSupportFragmentManager().getPrimaryNavigationFragment()).navigateUp();

            }
        }).start();

    }

    public Integer getTmp() {
        return tmp;
    }

    public SharedPreferences getPreferences() {
        return preferences;
    }
}