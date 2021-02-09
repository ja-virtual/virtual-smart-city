m2=${M2_REPO}
clsspth=src/main/resources
clsspth+=${clsspth}:${m2}/com/ing1/pds/vsc/virtual-smart-city/0.0.1-SNAPSHOT/virtual-smart-city-0.0.1-SNAPSHOT-jar-with-dependencies.jar
exec java -cp ${clsspth} com.ing1.pds.vsc.VSCBackServer.SmartCityAppService $*