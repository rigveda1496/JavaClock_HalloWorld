// インポートするライブラリ
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;

/**
 * MyFrameクラス: デジタル時計のウィンドウを表示するクラス
 * Timer を使用してUIスレッドをブロックせずに時刻を更新する
 */
public class MyFrame extends JFrame {
    
    // タイマー: 定期的に時刻を更新するために使用
    private Timer timer;
    
    // 日付と時間のフォーマット: SimpleDateFormatクラスを使用して日付と時間をフォーマット
    private final SimpleDateFormat timeFormat;
    private final SimpleDateFormat dayFormat;
    private final SimpleDateFormat dateFormat;
    
    // ラベル: 時計のウィンドウに表示されるラベル
    private final JLabel timeLabel;
    private final JLabel dayLabel;
    private final JLabel dateLabel;
    
    /**
     * MyFrameクラスのコンストラクタ: 時計のウィンドウを初期化する
     */
    public MyFrame() {
        // フォーマットを初期化
        timeFormat = new SimpleDateFormat("HH:mm:ss");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        
        // ウィンドウの設定
        setupWindow();
        
        // ラベルを初期化
        timeLabel = createTimeLabel();
        dayLabel = createDayLabel();
        dateLabel = createDateLabel();
        
        // レイアウト設定
        setupLayout();
        
        // 初回の時刻設定
        updateTime();
        
        // タイマーを開始（1000ms = 1秒間隔）
        startTimer();
        
        // ウィンドウを表示
        this.setVisible(true);
    }
    
    /**
     * ウィンドウの基本設定を行う
     */
    private void setupWindow() {
        this.setTitle("デジタル時計");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 250);
        this.setResizable(false);
        this.setLocationRelativeTo(null); // 画面中央に配置
        
        // ウィンドウが閉じられる時にタイマーを停止
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                stopTimer();
            }
        });
        
        // 背景色を設定
        this.getContentPane().setBackground(new Color(0x1E1E1E));
    }
    
    /**
     * 時刻表示用のラベルを作成
     */
    private JLabel createTimeLabel() {
        JLabel label = new JLabel();
        label.setFont(new Font("SansSerif", Font.BOLD, 48));
        label.setForeground(new Color(0x00FF41)); // 鮮やかな緑色
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }
    
    /**
     * 曜日表示用のラベルを作成
     */
    private JLabel createDayLabel() {
        JLabel label = new JLabel();
        label.setFont(new Font("SansSerif", Font.PLAIN, 28));
        label.setForeground(new Color(0xFFFFFF)); // 白色
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }
    
    /**
     * 日付表示用のラベルを作成
     */
    private JLabel createDateLabel() {
        JLabel label = new JLabel();
        label.setFont(new Font("SansSerif", Font.PLAIN, 20));
        label.setForeground(new Color(0xCCCCCC)); // 薄いグレー
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }
    
    /**
     * レイアウトを設定
     */
    private void setupLayout() {
        this.setLayout(new BorderLayout());
        
        // メインパネルを作成
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(0x1E1E1E));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // 各ラベルを中央揃えに設定
        timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // ラベル間にスペースを追加
        mainPanel.add(timeLabel);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(dayLabel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(dateLabel);
        
        this.add(mainPanel, BorderLayout.CENTER);
    }
    
    /**
     * タイマーを開始する
     */
    private void startTimer() {
        timer = new Timer(1000, e -> updateTime());
        timer.start();
    }
    
    /**
     * タイマーを停止する
     */
    private void stopTimer() {
        if (timer != null) {
            timer.stop();
        }
    }
    
    /**
     * 時刻表示を更新するメソッド
     * SwingのEventDispatchThreadで実行されるため、UIの更新が安全
     */
    private void updateTime() {
        try {
            Calendar now = Calendar.getInstance();
            
            String time = timeFormat.format(now.getTime());
            String day = dayFormat.format(now.getTime());
            String date = dateFormat.format(now.getTime());
            
            // ラベルのテキストを更新
            timeLabel.setText(time);
            dayLabel.setText(day);
            dateLabel.setText(date);
            
        } catch (Exception e) {
            // エラーが発生した場合の処理
            System.err.println("時刻更新中にエラーが発生しました: " + e.getMessage());
            timeLabel.setText("--:--:--");
            dayLabel.setText("---");
            dateLabel.setText("----年--月--日");
        }
    }
}
