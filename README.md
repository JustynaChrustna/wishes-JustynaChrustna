# Praca domowa po zajęciach nr 3 - "Wishes"

## Opis

Cześć!

Wiele osób twierdzi, że ten, kto wie jak działa Context i Intent, włada Androidem.
Zgadzam się z tymi słowami, a na ich potwierdzenie przygotowałem dla Ciebie zadanie, które polega na wykorzystaniu wcześniej już wymienionych fundamentalnych klas Androida do stworzenia funkcjonalnej aplikacji.
Aplikacja ma pozwolić użytkownikowi wybrać osobę, a następnie przy użyciu systemowego dialogu wybrać życzenia, które chcemy wysłać.

### Wymagania

Zadanie uznam za wykonane, gdy aplikacja:
1. Na kliknięcie w przycisk "Wybierz osobę" otworzy (poprzez wysłanie właściwego `Intentu`) systemowe `Activity` z listą kontaktów pozwalające na wybór numeru telefonu.
2. Odczyta przy użyciu dostarczonej klasy `PhoneNumberRetriever` numer wybranej osoby i przechowa na czas wyboru życzeń.
3. Na kliknięcie w przycisk "Wyślij życzenia" pokaże systemowy `AlertDialog`, który wyświetli i umożliwi wybór życzeń. Życzenia należy uzyskać poprzez użycie dostarczonej metody `getWishes(Context)`.
4. Na kliknięcie w życzenia wyświetlone w `AlertDialogu` aplikacja zamknie dialog i otworzy (poprzez wysłanie właściwie skonfigurowanego `Intentu`) aplikację SMS.
5. W otworzonej aplkikacji SMS treścią wiadomości będą wybrane wcześniej życzenia, a odbiorcą wybrany kontakt.

Pamiętajcie, by nie hardkodować stringów i używać klas z **androidx**, o których mówiliśmy na zajęciach.

## Termin

Pracę należy ukończyć przed **północą 30.11.2019** czasu środkowoeuropejskiego :)

Commity pojawiające się po tym terminie nie będą brane pod uwagę.

## Wskazówki

Ustawienie SingleChoiceItems
```kotlin
dialogBuilder.setSingleChoiceItems(someItems, somePositon) { dialog, selection -> 
  /*do something with selected item*/
}
```
#### Konfiguracja dialogu

https://devofandroid.blogspot.com/2018/03/how-to-create-singlechoice-alertdialog.html

#### Konfiguracja Intentów
https://developer.android.com/guide/components/intents-common

Powodzenia!

Kamil

