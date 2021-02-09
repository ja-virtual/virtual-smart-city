set m2=%M2_REPO%
set clsspth=%m2%\com\ing1\pds\vsc\virtual-smart-city\0.0.1-SNAPSHOT\virtual-smart-city-0.0.1-SNAPSHOT-jar-with-dependencies.jar
call java -cp %clsspth% com.ing1.pds.vsc.VSCBackServer.SmartCityAppService %*