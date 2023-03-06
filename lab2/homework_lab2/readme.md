# Homework - Lab 2 - Onofrei Maria

Proiectul se organizeaza in 3 pachete: Map, Location si Road.
Ofc, exista si fisierul Main.java.


-> Pachetul **Location** contine clasele *Location*, *Airport*, *City* si *GasStation*.

In *Locations* se afla atributele principale ale unei locatii (nume, tip, coordonate), dra si metode cum ar fi Obj.equals(), getLocationInformation() etc..
In *Airport* avem ca atribute specifice nr. de termionale si nr. de avioane ale aeroportului, iar metodele esunt cele generale de get() si set().
In *City* avem ca atribute specifice populatia si densitatea populatiei. Metodele sunt gele de get() si set().
In *GasStation* avem nr. de pompe benzinare, nr. de pompe diesel, pretul per litru al motorinei si pretul per litru al benzinei. In rest, metode de get() si set().


-> Pachetul **Road** se imparte in clasa *Road* si subclasele *CountryRoad*, *Express* si *Highway*. 

In *CountryRoad*, *Express* si *Highway* se gasesc numai constructorii subclaselor. In *Road* se afla atributele principale ale unui drum (locatii conectate, tip, lungime si limita de viteza (limita de viteza este fixa in functie de tipul drumului). La declararea unui drum, lungimea este testata sa fie mai mare sau cel putin egala cu distanta euclidiana dintre coordoanatele celor doua locatii. In clase se regasesc clasicele metode de get, dar si Obj.equals() care testeaza daca exista deja un drum cu exact aceleasi specificatii (adica daca este de acelasi tip, are exact aceeasi lungime si daca uneste exact aceeleasi locatii, indiferent de ordinea lor in momentul declararii drumului).


-> Pachetul **Map** contine clasele *Map* si *BestRouteProblem*.

Clasa *Map* este cea care face contorizarea si indexarea tuturor locatiilor si drumurilor prin doua ArrayLists, cate o lista pt fiecare tip. Pe langa metodele de get() specifice, in clasa se mai afla si metodele de add() si remove(). Metodele de addLocation() si addRoad() sunt speciale in sensul ca aici se face testarea astfel incat in oricare map sa nu existe doua locatii sau doua drumuri cu aceleasi specificatii (testarea se face cu ajutorul metodei Obj.equals() ale fiecarei clase *location* si *Road*). 

Clasa *BestRouteProblem* eset cea care instantiaza datele problemei cu acelasi nume. Singurul atribut al listei este un ArrayList care va contine la final drumul de la startLocation si pana la endLocation. De acesta data, constructorul clasei deserveste si pe post de algoritm de rezolvare deoarece aici se gaseste si se afiseaza cel mai SCURT drum de la start la finish. Totodata, se face si verificare locatiilor introduse - se verifica daca fac parte din map-ul dat, dar si daca in primul rand exista macar un drum care sa uneasca cele doua entitati si sa existe si acesta in map.
