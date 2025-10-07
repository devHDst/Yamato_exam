1.大和試験問題確認用コマンド(java)

前提条件：すでにgithubでクローンされたプロジェクトに遷移済みであること。javaのバージョンが17であること。
問１回答.以下のコマンドを実行。
java ./app/src/main/java/yamato/App.java "apple\tfruit:sale\nbanana:cherry\tfruit\n\tbeverage"
問2回答
java ./app/src/main/java/yamato/App.java "fruit\tapple\nfruit\tbanana\nbeverage\t\nfruit\tbanana\nbeverage\tcoke\npet\tdog"

2.大和試験問題確認用コマンド(jar)
前提条件：すでにgithubでクローンされたプロジェクトに遷移済みであること。javaのバージョンが17であること。
(1)ルートディレクトリにコンソールで遷移後、以下のコマンドでビルドする。
./gradlew clean build  
(2)問題に応じで以下のコマンド実行後のコンソールを確認する。
問１
java -jar app/build/libs/app.jar "apple\tfruit:sale\nbanana:cherry\tfruit\n\tbeverage"
問2
java -jar app/build/libs/app.jar "fruit\tapple\nfruit\tbanana\nbeverage\t\nfruit\tbanana\nbeverage\tcoke\npet\tdog"
