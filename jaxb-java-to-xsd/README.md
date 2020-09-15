Ecrivez les entités jaxb correspondant au XSD donné.
Pour valider votre réponse, décommanter le test fr.pantheonsorbonne.ufr27.miage.ExoTest et faites en sorte qu'il passe au vert.

```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:tns="http://miage.ufr27.pantheonsorbonne.fr" elementFormDefault="qualified" targetNamespace="http://miage.ufr27.pantheonsorbonne.fr" version="1.0">
    
  
    
  <xs:element name="panier" type="tns:panier"/>
    
  <xs:complexType name="article">
        
    <xs:sequence>
            
      <xs:element minOccurs="0" name="denomination" type="xs:string"/>
            
      <xs:element name="prixUnitaire" type="xs:double"/>
          
    </xs:sequence>
      
  </xs:complexType>
    
  <xs:complexType name="client">
        
    <xs:sequence>
            
      <xs:element minOccurs="0" name="addresse" type="xs:string"/>
            
      <xs:element name="fname" type="xs:string"/>
            
      <xs:element name="lname" type="xs:string"/>
            
      <xs:element name="personneMorale" type="xs:boolean"/>
            
      <xs:element name="zipCode" type="xs:int"/>
          
    </xs:sequence>
      
  </xs:complexType>
    
  <xs:complexType name="compte">
        
    <xs:sequence/>
      
  </xs:complexType>
    
   
    
  <xs:complexType name="panier">
        
    <xs:sequence>
            
      <xs:element name="articles">
                
        <xs:complexType>
                    
          <xs:sequence>
                        
            <xs:element maxOccurs="unbounded" minOccurs="0" name="article" type="tns:article"/>
                      
          </xs:sequence>
                  
        </xs:complexType>
              
      </xs:element>
            
      <xs:element minOccurs="0" name="client" type="tns:client"/>
            
      <xs:element name="total" type="xs:double"/>
          
    </xs:sequence>
      
  </xs:complexType>
  
</xs:schema>

```