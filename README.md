# Java時計

## 概要

Javaで作成された時計プログラムです。時計の機能を実現するために、JavaのGUIライブラリを使用しています。

## 機能

* 時計の表示
* 時間の更新
* 日付の表示

![時計の表示](https://example.com/clock.png)

## 使い方

1. プログラムをダウンロードします。
2. プログラムを実行します。
3. 時計の表示を確認します。

![プログラムの実行](https://example.com/run-program.png)

## 開発環境

* Eclipse本体
 + バージョン: 2020-06
 + OS: Windows 10
* Pleiades
 + バージョン: 6.0.3
 + OS: Windows 10

![Eclipseの開発環境](https://example.com/eclipse-env.png)

## コード解説

### ウィンドウ設定部分

* `this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);` : ウィンドウが閉じたときにプログラムが終了するように設定しています。JavaのGUIアプリケーションにおける基本的な設定であり、ユーザーが使いやすいアプリを作るために重要です。

### レイアウトとサイズ設定

* `this.setLayout(new FlowLayout());` : FlowLayoutを使って、ウィンドウ内の各要素（時刻、曜日、日付）を順番に配置しています。
* `this.setSize(350, 200);` : ウィンドウのサイズを固定し、見やすいレイアウトにしています。この配置は、他のGUIアプリケーションでも応用できます。

### 時間フォーマット設定

* `timeFormat = new SimpleDateFormat("hh:mm:ss a");` : SimpleDateFormatを用いて、時刻や日付の表示形式を設定しています。例えば、「hh:mm:ss a」で時間を「午前/午後」形式にフォーマットし、「EEEE」で曜日を表示しています。表示形式の指定はユーザーの利便性を高めます。

### ラベル設定（色とフォントのカスタマイズ）

* `timeLabel.setFont(new Font("", Font.PLAIN, 50));` : 時間表示用のラベルにカスタムフォントを設定しています。
* `timeLabel.setForeground(new Color(0x00FF00));` : 時間表示用のラベルに文字色を設定しています。
* `timeLabel.setBackground(Color.black);` : 時間表示用のラベルに背景色を設定しています。
* `timeLabel.setOpaque(true);` : 時間表示用のラベルに背景を設定しています。このカスタマイズにより、見やすく視認性の高いデザインが実現されています。ユーザーが画面をすぐに読み取れるように工夫しています。

### 無限ループで時計を更新する部分

* `while(true) {... }` : whileループを使って、1秒ごとに時刻と日付を更新しています。
* `Thread.sleep(1000);` : 1秒の待機時間を設けることで、毎秒ごとに正確な時刻を表示します。この仕組みによって、ユーザーがリアルタイムで時間の経過を確認できるようになります。

### 実行時のウィンドウプレビュー

![実行時のウィンドウ](./ScreenShot2024-04-04 183433.png)

* アプリケーションを実行したときの画面のスクリーンショットを追加します。時計が中央に配置され、現在の時刻、曜日、日付が見やすく表示されている様子を示します。アプリが実際に動作する様子を視覚的に確認できるため、プロジェクトの成果が一目でわかります。特にUIの配置や色のカスタマイズの効果がここで分かります。
