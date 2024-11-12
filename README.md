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

## インポートするライブラリ

* `java.awt` : JavaのGUIライブラリ
 + `Color` : 色のクラス
 + `FlowLayout` : レイアウトマネージャーのクラス
 + `Font` : フォントのクラス
* `java.text` : Javaのテキストライブラリ
 + `SimpleDateFormat` : 日付と時間のフォーマットのクラス
* `java.util` : Javaのユーティリティライブラリ
 + `Calendar` : 日付と時間のクラス
* `javax.swing` : Javaのスイングライブラリ
 + `JFrame` : フレームのクラス
 + `JLabel` : ラベルのクラス

![インポートするライブラリ](https://example.com/import-libraries.png)

## クラスと変数

* `MyFrame` : 時計のウィンドウを表示するためのクラス
* `Calendar` : 日付と時間を取得するためのクラス
 + `calendar` : カレンダーのインスタンス
* `SimpleDateFormat` : 日付と時間のフォーマットを指定するためのクラス
 + `timeFormat` : 時間のフォーマット
 + `dayFormat` : 日付のフォーマット
 + `dateFormat` : 日付のフォーマット
* `JLabel` : 時計のウィンドウに表示されるラベルのクラス
 + `timeLabel` : 時間のラベル
 + `dayLabel` : 日付のラベル
 + `dateLabel` : 日付のラベル
* `String` : 日付と時間の文字列
 + `time` : 時間の文字列
 + `day` : 日付の文字列
 + `date` : 日付の文字列

![クラスと変数](https://example.com/classes-and-variables.png)

## コード

```java
// Java時計プログラムのコード
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame{
 
    //...
}
