# Homework - Lab 7 - Onofrei Maria

Proiectul este impartit in 6 clase: Exploration, SharedMemory, Token, Map, Cell si Robot.

Clasa Robot sustine entitatea robot care va parcurge o mapa sub forma de matrice n x n de tip Cell. In fiecare Cell din Map vor fi stotate mai multe Tokens preluate din SharedMemory. La inceput, robotii sunt pusi aleatoriu in Map, mai apoi putand sa se deplaseze in orice casuta din preazma lor, cu conditia ca aceasta sa nu fie deja vizitata. In fiecare casuta vizitata se salveaza n Tokens. Algoritmul are functionalitatea de a arata pozitia fiecarui robot dupa orice mutare a sa, sa afiseze daca robotul este blocat (toate casutele din jurul sau sunt vizitate, desi Map-ul nu este conplet vizitat), dar si sa spuna daca Map-ul este complet vizitat.

In plus, acum exista si un time tread care se poate seta astfel incat parcurgerea sa nu intreaca un anumit numar de secunde. Exista posibilitatea de a executa comenzile de start/pause asupra oricarui robot, dar si asupra tuturor robotilor odata. Bineinteles, la final de executie, chiar daca map-ul a fost sau nu complet parcurs, se va afiza pt fiecare robot nr de tokenuri pe care fiecare l-a extras. 
