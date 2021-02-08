m2=${M2_REPOS}
clsspth=src/main/resources
clsspth+=${clsspth}:${m2}/upec/ing1/pds/vsc/virtual-smart-city/0.0.1-SNAPSHOT/virtual-smart-city-0.0.1-SNAPSHOT.jar
exec java -cp ${clsspth} upec.ing1.pds.vsc.VSCBackServer.SmartCityAppService $*