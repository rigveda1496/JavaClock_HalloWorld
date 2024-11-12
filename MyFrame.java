// インポートするライブラリ
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

// MyFrameクラス: 時計のウィンドウを表示するために使用するクラス
public class MyFrame extends JFrame{
 
 // カレンダー: 日付と時間を取得するために使用するクラス
 Calendar calendar;
 
 // 日付と時間のフォーマット: SimpleDateFormatクラスを使用して日付と時間をフォーマットする
 SimpleDateFormat timeFormat;
 SimpleDateFormat dayFormat;
 SimpleDateFormat dateFormat;
 
 // ラベル: 時計のウィンドウに表示されるラベル
 JLabel timeLabel;
 JLabel dayLabel;
 JLabel dateLabel;
 
 // 日付と時間の文字列
 String time;
 String day;
 String date;

 // MyFrameクラスのコンストラクタ: 時計のウィンドウを初期化する
 MyFrame(){
  // ウィンドウの終了方法を設定する
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  // ウィンドウのタイトルを設定する
  this.setTitle("My Clock Program");
  // ウィンドウのレイアウトを設定する
  this.setLayout(new FlowLayout());
  // ウィンドウのサイズを設定する
  this.setSize(350,200);
  // ウィンドウのサイズを変更できるかどうかを設定する
  this.setResizable(false);
  
  // 日付と時間のフォーマットを設定する
  timeFormat = new SimpleDateFormat("hh:mm:ss a");
  dayFormat = new SimpleDateFormat("EEEE");
  dateFormat = new SimpleDateFormat("yyyy.MM.dd G");
  
  // ラベルを初期化する
  timeLabel = new JLabel();
  timeLabel.setFont(new Font("",Font.PLAIN,50));
  timeLabel.setForeground(new Color(0x00FF00));
  timeLabel.setBackground(Color.black);
  timeLabel.setOpaque(true);
  
  dayLabel = new JLabel();
  dayLabel.setFont(new Font("monospaced",Font.PLAIN,35));
  
  dateLabel = new JLabel();
  dateLabel.setFont(new Font("",Font.PLAIN,25));
  
  
  // ラベルをウィンドウに追加する
  this.add(timeLabel);
  this.add(dayLabel);
  this.add(dateLabel);
  // ウィンドウを表示する
  this.setVisible(true);
  
  // 時計を更新する
  setTime();
 }
 
 // 時計を更新するメソッド
 public void setTime() {
  // 無限ループで時計を更新する
  while(true) {
  // 日付と時間を取得する
  time = timeFormat.format(Calendar.getInstance().getTime());
  timeLabel.setText(time);
  
  day = dayFormat.format(Calendar.getInstance().getTime());
  dayLabel.setText(day);
  
  date = dateFormat.format(Calendar.getInstance().getTime());
  dateLabel.setText(date);
  
  // 1秒待つ
  try {
   Thread.sleep(1000);
  } catch (InterruptedException e) {
   e.printStackTrace();
  }
  }
 }
}
