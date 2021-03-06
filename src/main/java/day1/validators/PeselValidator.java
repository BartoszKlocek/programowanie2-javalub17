package day1.validators;/*
Rozważmy PESEL osoby urodzonej 8 lipca 1902 roku, płci żeńskiej (parzysta końcówka numeru z serii – 0362). Czyli mamy wówczas 0207080362.
Teraz kolejne cyfry należy przemnożyć przez odpowiednie wagi i dodać do siebie.
0*1 + 2*3 + 0*7 + 7*9 + 0*1 + 8*3 + 0*7 + 3*9 + 6*1 + 2*3 = 0 + 6 + 0 + 63 + 0 + 24 + 0 + 27 + 6 + 6 = 132
Wynik dzielimy modulo przez 10.
132 mod 10 = 2
A następnie odejmujemy od 10
10 - 2 = 8.
I wynik dzielimy znów modulo 10
8 mod 10 = 8
Cyfra kontrolna to 8, zatem nasz prawidłowy numer PESEL to: 02070803628
 */


public class PeselValidator {

    public boolean validate(String pesel) {
        //nie pozwalamy zeby pesel był nullem

        if (pesel == null) {
            return false;

        }
        // nie pozwalamy na dlugosc inna niz 11 znakow
        if (pesel.length() != 11) {
            return false;
        }

        //przetowrzenie ciagu znakow na tablice znakow
        char[] cyfryZnaki = pesel.toCharArray();

        int[] cyfry = new int[cyfryZnaki.length];

        //for (char znak : cyfryZnaki){
        //}


        //przetworzenie tablicy znaków na tablice liczb

        try {
            for (int i = 0; i < cyfryZnaki.length; i++) {
                cyfry[i] = Integer.valueOf(String.valueOf(cyfryZnaki[i]));
            }
        } catch (NumberFormatException e) {
            return false;
        }

        int suma = cyfry[0] * 1 + cyfry[1] * 3 + cyfry[2] * 7 + cyfry[3] * 9 + cyfry[4] * 1 + cyfry[5] * 3 + cyfry[6] * 7 + cyfry[7] * 9 + cyfry[8] * 1 + cyfry[9] * 3;

        suma = suma % 10;
        suma = 10 - suma;
        suma = suma % 10;

        return suma == cyfry[10];
    }
}