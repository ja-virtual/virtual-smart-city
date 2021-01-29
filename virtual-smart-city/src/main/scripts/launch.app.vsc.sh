m2-${M2_REPO}
clsspth=src/main/resources
clsspth+=${clsspth}:${m2} /upec/ing1/pds/vsc/demo/VSCApplicationDemo/1.0-SNAPSHOT/VSCApplicationDemo-1.0-SNAPSHOT-jar-with-dependencies.jar
exec java -cp ${clsspth} upec.ing1.pds.vsc.demo.VSCApplicationDemo $*
#mvn clean compile install package verify test