# IbanChecker
## Sąskaitų numerių IBAN tikrinimas
- [x]  Interaktyvus IBAN numerių tikrinimas. Vartotojo paprašoma įvesti sąskaitos numerį ir programa išveda ar numeris yra teisingas
- [x] IBAN numerių iš tekstinio failo tikrinimas. Vartotojo paprašoma įvesti failo kelią ir pavadinimą. Programa nuskaito failą ir sutikrina sąskaitos numerius. Rezultatus išveda į tokio pat pavadinimo failą su plėtiniu .out. 

        Pradinio failo struktūra: kiekviena eilutė - vienas sąskaitos numeris IBAN. Pvz:
            AA051245445454552117989
            LT647044001231465456
            LT517044077788877777
            LT227044077788877777
            CC051245445454552117989

        Rezultato failo struktūra: IBAN;valid. Pvz:
            AA051245445454552117989;false
            LT647044001231465456;true
            LT517044077788877777;true
            LT227044077788877777;false
            CC051245445454552117989;false
            
Apie IBAN: https://en.wikipedia.org/wiki/International_Bank_Account_Number  

## Programos vystymasis
Iš eilės tikrinama:
1. IBAN numerio ilgis
1. Ar yra nevartotinų simbolių IBAN numeryje.
1. IBAN kontrolinė suma
1. Šalies IBAN palaikymas

Neatliekami tikrinimai:
* Sąskaitors numerio kontrolinės sumos (BBAN) tikrinimas (šalys turi skirtingus BBAN formatus)
* IBAN formatas ir struktūra (šalys turi skirtingus formatus ir struktūras)

Spausdinami rezultatai terminale:
* `IBAN nėra validus - Netinkamas IBAN numerio ilgis`
* `IBAN nėra validus - Numeryje yra nevartotinų simbolių`
* `IBAN nėra validus - Netinkama IBAN kontrolinė suma`
* `IBAN nėra validus - Šalies nepalaiko IBAN`
* `IBAN yra validus`

## Projekto struktūra
* Iban
  * `IbanAPI.java`
  * `InputHandling.java`
* `IbanCheck.java`
* Tests
 * `FailCheckTests.java`
 * `PassCheckTests.java`
 * `TestRunner`

## Darbų sąrašas
* Sukurti daugiau testų
* Išskaidyti turimas funkcijas toliau, kad galima būtu testuoti skirtingas funkcijų dalis
* Sąskaitos numerio kontrolinės sumos (BBAN) tikrinimas (šalys turi skirtingus BBAN formatus)
* IBAN formatas ir struktūra (šalys turi skirtingus formatus ir struktūras)
* Padaryti service, kuris validuotu IBAN naudojantis jau sukurtomis funkcijomis

## Kitas galimas funkcionalumas
* Grafinė sąsaja
