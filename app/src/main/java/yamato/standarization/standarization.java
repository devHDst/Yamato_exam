package yamato.standarization;

import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class standarization {
    
    /** 1. 第一正規化 */
    public static void standardizeTSV(BufferedReader br) throws Exception{
        String line = null;
        
        while (br.readLine() != null) {

            // TSVデータの内容を1行ずつ読み取る
            line = br.readLine();

            // タブ区切りで列に分解
            String key = line.split("\t", -1)[0];
            String value = line.split("\t", -1)[1];
            // グループ区切りでさらに分解
            String[] keyContents = key.split(":", -1);
            String[] valueContents = value.split(":", -1);
            
            // 分解した列を正規化して出力
            for (String keyString : keyContents) {
                for (String valueString : valueContents) {
                    // 第一正規化を行ごとに出力
                    System.out.println(keyString + "\t" + valueString);
                }
            }
        }
    }

    /** 2.第一正規化の逆変換 */
    public static void revrerseStandardizeTSV(BufferedReader br) throws Exception{
        String line = null;
        // 2重配列でデータを集計
        Map<String, String> keyValueMap = new HashMap<>();
        String key = "";
        String value = null;
        
        while (br.readLine() != null) {

            // TSVデータの内容を1行ずつ読み取る
            line = br.readLine();
            // キー情報を集計
            key = line.split("\t", -1)[0];

            // 各グループごとに値を集計
            if(keyValueMap.containsKey(key)){
                StringBuilder sb = new StringBuilder();
                // 既にキーが存在する場合、今の行の値を「：」で連結して上書き
                sb.append(value).append(":").append(line.split("\t", -1)[1]);
                value = sb.toString();
                keyValueMap.put(key, value);
            }else{
                // キーが存在しない場合、新規グループ登録
                value = line.split("\t", -1)[1];
                keyValueMap.put(key, value);
            }
        }

        // Mapで集計済みになっているので、キーと値をタブ区切りで出力
        for (Entry<String, String> tsvOutput : keyValueMap.entrySet()) {
            System.out.println(tsvOutput.getKey() + "\t" + tsvOutput.getValue());
        }
    }
}
