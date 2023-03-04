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


**Clasa Locations:**

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
