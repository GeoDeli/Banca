# Banca contine o aplicatie de monitorizare a clientilor cand acestia isi modifica soldul.

 Aplicatia are o interfata ce permite utilizatorului sa selecteze una din 3 actiuni posibile:
 
 1. Creare cont
   
   In acest caz se creaza un utilizator introducand CNP-ul si valorile pentru cele 2 conturi disponibile: EURO si LEI. In cazul in care utilizatorul introduce un caracter nepermis este semnalat acest lucur. Este antentionat si daca numarul de cifre din CNP nu este 13. Pentru a proteja aplicatia de introducerea informatiilor necorespunzatoare s-a dezactivat butonul de creare a unui utilizator. Se permite crearea unui utilizator doar in cazul in care toate campurile sunt corespuzatoare.
   
 2. Autentificare client
   
   In acest caz utilizatorul se atuentifica folosind CNP-ul sau, precum si un ID primit la crearea contului. In continuare utilizator se va intalni cu o interfata ce ii permite din nou sa selecteze una din 4 actiuni posibile: 
         
         Informatii cont: ce afiseaza printr-o notificare informatiile curente ale contului
         
         Lichidiare conturi: stergerea contului utilizatorului daca ambele sale solduri sunt 0
         
         Depozitare: depunerea in conturile proprii, caz in care se deschide o interfata ce permite utilizatorului sa introduca doar valori corespunzatoare
         
         Retragere: retragerea unei sume din conturile proprii, caz in care se verifica si daca soldul ramas este mai mare de 1000 de EURO/RON. In caz contrar retragerea nu se poate efectua. 

3. Fisc/Monitorizare
  
  Aceasta interfata permite fiscului sa vizualizeze clientii nemonitorizati precum si pe cei monitorizati. Monitoriarea oricarui client include o notificare in cazul in care soldurile clientului s-au modificat, precum si cu ce valori. Monitorizarea oricarui client se realizeaza selectand un client si actionand butonul de monitorizare. La fel si in cazul opriri monitorizarii.
  
  Nota: Aplicatia verifica informatiile introduse ale utilizatorului pentru a preveni SQLInjections si alte erori posibile
