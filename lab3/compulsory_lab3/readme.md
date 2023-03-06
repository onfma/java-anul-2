# Compulsory - Lab 3 - Onofrei Maria

Codul este organizat in 4 fisiere: Main.java, interfata INode si clasele Person si Company care implementeaza interfata

**- INode**: 
  interfata are o singura metoda, getName(), care returneaza numele fie a unei perosnae ori a unei companii

**- Person**: 
  clasa care implementeaza interfata, dar si Comparable<Person> unde sortarea persoanelor se face in ordine alfabetica dupa nume
  o persoana este identificata prin nume, dar poate avea si un rol aditional (doar "programmer" sau "designer"
  
**- Company**: 
  clasa care implementeaza interfata, dar si Comparable<Company> unde sortarea companiilor se face in ordine alfabetica dupa nume
  o companie este identificata prin nume, nu exista alte atribute 
  
**- Main**
  in Main.java avem doua ArrayLists, unul pentru comnaii si altul pt persoane; prin acestea se realizaza sortarea componentelor
  in Main.java avem o lista de Nodes care incorporeaza toate persoanele si toate companiile si mai apoi afiseaza pe ecran toate nodurile din acesata lista
