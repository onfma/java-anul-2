# Compulory - Lab 2 - Onofrei Maria - 2A2

Proiectul se organizeaza in 3 clase: *Map, Location* si *Road*


**Clasa Map:** contorizeaza si stocheaza o multitudine de locatii si drumuri prin doua ArrayLists (una pt locatii, cealalta pt drumuri)

     Contstructorul: creeaza cele doua liste, momentan goale
            
     Medoda <<addLoacation>>: introduce o locatie noua in map prin adugarea ei in ArrayList
     Medoda <<addRoad>>: introduce un drum noua in map prin adugarea lui in ArrayList
     Metoda <<removeLocation>>: sterge din map locatia prin eliminarea ei din ArrayList
     Metoda <<removeRoad>>: sterge din map drumul prin eliminarea lui din ArrayList
     Metoda <<toString>>: returneaza toate informatiile despre toate locatiile si drumurile aflate in map
     Metoda <<getMap>>: afiseaza pe ecran toate informatiile date de <<toString>>
     Metoda <<getAllLocations>>: afiseaza pe ecran toate informatiile despre locatiile care se afla in map
     Metoda <<getAllRoads>>: afiseaza pe ecran toate informatiile depre drumurile care se afla in map
     Metoda <<distanceBetween2Locations>: returneaza distanta dintre doua locatii oarecare


**Clasa Location:**

     Contstructorul: creeaza o noua locatie prin introducerea a 4 parametrii
       - name: numele locatiei
       - type: tipul locatiei (City, Airport, GasStation)
       - x: coordonata X a locatiei
       - y: coordonata Y a locatiei
              
     Metoda <<toString>>: returneaza toate informatiile despre locatia data
     Metoda <<getLocationInformation>>: afiseaza pe ecran toate info date de <<toString>
     Metoda <<getLocationName>>: returneaza numele locatiei
     Metoda <<getLocationType>>: returneaza tipul locatiei
     Metoda <<getLocationCoordinateX>>: returneaza coordonata X a locatiei
     Metoda <<getLocationCoordinateY>>: returneaza coordonata Y a locatiei
     

**Clasa Road:**

     Contstructorul: creeaza un nou drum prin introducerea a 5 parametrii
       - location1: una din locatiile aflate la un capat de drum
       - location2: cealalta locatie de la capatul opus al drumului
       - type: tipul drumului (Highway, Express, Country)
       - length: lungimea drumului care treb sa fie mai mare sau egala ca distanta euclidiana dintre coordonatele celor doua locatii
       - speed limit: limita de viteza a drumului
              
     Metoda <<toString>>: returneaza toate informatiile despre drumul dat
     Metoda <<getRoadInformation>>: afiseaza pe ecran toate info date de <<toString>
     Metoda <<getRoadPosition>>: afiseaza pe ecran cele doua locatii interconectate de drum
     Metoda <<getRoadType>>: afiseaza pe ecran tipul drumului
     Metoda <<getRoadLength>>: returneaza lungimea drumului
     Metoda <<getRoadSpeedLimit>>: afiseaza pe ecran limita de viteza a drumului
