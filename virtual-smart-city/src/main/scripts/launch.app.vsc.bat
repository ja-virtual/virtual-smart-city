set m2=%M2_REPO
set clsspth=%m2%\edu\si\ing1\pds\vsc\virtual-smart-city\1.0-SNAPSHOT\virtual-smart-city-1.0-SNAPSHOT-jar-with-dependencies.jar
call java -cp %clsspth% edu.si.ing1.pds.vsc.server.SmartCityAppService %*

