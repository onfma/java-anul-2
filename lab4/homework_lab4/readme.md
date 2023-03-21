# Homework - LAB 4 - Onofrei Maria

Proiectul se organizeaza in 3 clase: *Student*, *Project* si *StudentProjectProblem*.

Fiecare obiect de tip student are o lista de proiecte admisibile care pot fi adaugate fie Project cu Project, fie cu ajutorul unei liste de tip Project. 

In clasa *StudentProjectProblem*, constructorul este cel care contine algoritmul de rezolvare al problemei: exista 2 liste care contin toti studentii si toate proiectele. Lista de studenti este ordonata crescator in functie de numarul de proiecte admisibile pe care le are fiecare student. Algoritmul parcurge aceasta lista ordonata de studenti si asigneaza primul proiect admisibil din lista fiecarui student, numai daca acest proiect nu a mai fost deja asignat. Daca primul proiect din lista nu este disponibil, atunci si trece la urmatorul si tot asa.

De asemenea, clasa *StudentProjectProblem* contine si metoda care returneaza cati studenti au nr de proiecte admisibil mai mic decat media generala de proiecte admisibile per student.

In *Main*, studentii si proiectele sunt generate cu ajutorul unor streamuri si a unui faker care genereaza nume atat pt studenti, cat si pt proiecte.
