package helper.calculation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Calculator {
    /**
     * Fungsi untuk menampilkan semua data mengenai semua nilai beserta frekuensi kemunculannya
     *
     * @param dataNilai parameter berupa array integer untuk data nilai per kelas
     * @return string berisi semua data nilai beserta frekuensinya
     */
    public String scoreAndFrequencies(int[] dataNilai) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<Integer, Integer> scoreFrequenciesMapping = new HashMap<>();

        // Mengisi map dengan key-value berupa nilai-frekuensi
        for (int i = 0; i < dataNilai.length; i++) {
            if (i == 0) {
                scoreFrequenciesMapping.put(dataNilai[i], 1);
            } else {
                if (scoreFrequenciesMapping.containsKey(dataNilai[i])) {
                    scoreFrequenciesMapping.put(dataNilai[i], scoreFrequenciesMapping.get(dataNilai[i]) + 1);
                } else {
                    scoreFrequenciesMapping.put(dataNilai[i], 1);
                }
            }
        }

        // Membaca data dari hashmap yang sudah berisi nilai-frekuensi
        for (Map.Entry<Integer, Integer> mapSet : scoreFrequenciesMapping.entrySet()) {
            stringBuilder.append("Nilai: ")
                    .append(mapSet.getKey())
                    .append(", frekuensi: ")
                    .append(mapSet.getValue())
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    /**
     * Fungsi/algoritma untuk mencari nilai median dari suatu deret nilai
     *
     * @param dataNilai parameter untuk array integer berupa data nilai per kelas
     * @return hasil dari pencarian median
     */
    public String medianSearch(int[] dataNilai) {
        double median;
        Arrays.sort(dataNilai);
        if (dataNilai.length % 2 == 0) {
            median = (dataNilai[(dataNilai.length / 2) - 1] + dataNilai[dataNilai.length / 2]) / 2.0;
        } else {
            median = dataNilai[(dataNilai.length - 1) / 2];
        }
        return Double.toString(median);
    }

    /**
     * Fungsi/algoritma untuk mencari nilai rata-rata/mean suatu deret nilai
     *
     * @param dataNilai parameter untuk array integer berupa data nilai per kelas
     * @return hasil dari pencarian nilai rata-rata
     */
    public String meanSearch(int[] dataNilai) {
        int jumlah = 0;
        double mean;
        for (int nilai : dataNilai) {
            jumlah += nilai;
        }
        mean = (double) jumlah / dataNilai.length;
        return Double.toString(mean);
    }

    /**
     * Fungsi/algoritma untuk mencari modus dari suatu deret nilai
     *
     * @param dataNilai parameter untuk array integer berupa data nilai per kelas
     * @return hasil dari pencarian modus
     */
    public String modusSearch(int[] dataNilai) {
        int counter = 1, temp, tempCounter;
        int modus = dataNilai[0];
        for (int i = 0; i < dataNilai.length - 1; i++) {
            temp = dataNilai[i];
            tempCounter = 1;
            for (int j = 1; j < dataNilai.length; j++) {
                if (temp == dataNilai[j]) {
                    tempCounter++;
                }
            }
            if (tempCounter > counter) {
                modus = temp;
                counter = tempCounter;
            }
        }
        return Integer.toString(modus);
    }
}
