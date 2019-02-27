package com.pm.entity;

public class FileUp {

//外键
    private User myUser;

    public User getMyUser() {
        return myUser;
    }

    public void setMyUser(User myUser) {
        this.myUser = myUser;
    }

    private MyKeyword myKeywordEntity;

    private MyKeyword myKeywordEntityc;

    public MyKeyword getMyKeywordEntityc() {
        return myKeywordEntityc;
    }

    public void setMyKeywordEntityc(MyKeyword myKeywordEntityc) {
        this.myKeywordEntityc = myKeywordEntityc;
    }

    public MyKeyword getMyKeywordEntity() {
        return myKeywordEntity;
    }

    public void setMyKeywordEntity(MyKeyword myKeywordEntity) {
        this.myKeywordEntity = myKeywordEntity;
    }





    private Long id;

    private String fileName;

    private String filePath;

    private String fillePathbig;

    private String filePathmid;

    private String filePathsmall;

    private String filePathshow;

    private Long userId;

    private Integer stateId;

    private Integer mode;

    private String cameraman;

    private String pictureName;

    private Integer indexSlide;

    private Integer indexAnimal;

    private Integer indexPlant;

    private Integer indexScape;

    private String instruction;

    private String owner;

    private String ownerNumber;

    private String reason;

    private Integer direction;

    private Integer species;

    private Long keyone;

    private Long keytwo;

    private String keythree;

    private Integer indexVideo;

    private Double pathPrice;

    private Double bigpathPrice;

    private Double midpathPrice;

    private Double smallpathPrice;

    public FileUp(Long id, String fileName, String filePath, String fillePathbig, String filePathmid, String filePathsmall, String filePathshow, Long userId, Integer stateId, Integer mode, String cameraman, String pictureName, Integer indexSlide, Integer indexAnimal, Integer indexPlant, Integer indexScape, String instruction, String owner, String ownerNumber, String reason, Integer direction, Integer species, Long keyone, Long keytwo, String keythree, Integer indexVideo, Double pathPrice, Double bigpathPrice, Double midpathPrice, Double smallpathPrice) {
        this.id = id;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fillePathbig = fillePathbig;
        this.filePathmid = filePathmid;
        this.filePathsmall = filePathsmall;
        this.filePathshow = filePathshow;
        this.userId = userId;
        this.stateId = stateId;
        this.mode = mode;
        this.cameraman = cameraman;
        this.pictureName = pictureName;
        this.indexSlide = indexSlide;
        this.indexAnimal = indexAnimal;
        this.indexPlant = indexPlant;
        this.indexScape = indexScape;
        this.instruction = instruction;
        this.owner = owner;
        this.ownerNumber = ownerNumber;
        this.reason = reason;
        this.direction = direction;
        this.species = species;
        this.keyone = keyone;
        this.keytwo = keytwo;
        this.keythree = keythree;
        this.indexVideo = indexVideo;
        this.pathPrice = pathPrice;
        this.bigpathPrice = bigpathPrice;
        this.midpathPrice = midpathPrice;
        this.smallpathPrice = smallpathPrice;
    }


    public FileUp(Long id, Integer mode, String cameraman, String pictureName, String instruction, String owner, String ownerNumber, String reason, Integer direction, Integer species, Long keyone, Long keytwo, String keythree, Double pathPrice, Double bigpathPrice, Double midpathPrice, Double smallpathPrice) {
        this.id = id;
        this.mode = mode;
        this.cameraman = cameraman;
        this.pictureName = pictureName;
        this.instruction = instruction;
        this.owner = owner;
        this.ownerNumber = ownerNumber;
        this.reason = reason;
        this.direction = direction;
        this.species = species;
        this.keyone = keyone;
        this.keytwo = keytwo;
        this.keythree = keythree;
        this.pathPrice = pathPrice;
        this.bigpathPrice = bigpathPrice;
        this.midpathPrice = midpathPrice;
        this.smallpathPrice = smallpathPrice;
    }

    public FileUp(Long id, Integer mode, String cameraman, String pictureName, String instruction, String owner, String ownerNumber, String reason, Integer direction, Integer species, Long keyone, Long keytwo, String keythree, Double pathPrice) {
        this.id = id;
        this.mode = mode;
        this.cameraman = cameraman;
        this.pictureName = pictureName;
        this.instruction = instruction;
        this.owner = owner;
        this.ownerNumber = ownerNumber;
        this.reason = reason;
        this.direction = direction;
        this.species = species;
        this.keyone = keyone;
        this.keytwo = keytwo;
        this.keythree = keythree;
        this.pathPrice = pathPrice;
    }



    public FileUp() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getFillePathbig() {
        return fillePathbig;
    }

    public void setFillePathbig(String fillePathbig) {
        this.fillePathbig = fillePathbig == null ? null : fillePathbig.trim();
    }

    public String getFilePathmid() {
        return filePathmid;
    }

    public void setFilePathmid(String filePathmid) {
        this.filePathmid = filePathmid == null ? null : filePathmid.trim();
    }

    public String getFilePathsmall() {
        return filePathsmall;
    }

    public void setFilePathsmall(String filePathsmall) {
        this.filePathsmall = filePathsmall == null ? null : filePathsmall.trim();
    }

    public String getFilePathshow() {
        return filePathshow;
    }

    public void setFilePathshow(String filePathshow) {
        this.filePathshow = filePathshow == null ? null : filePathshow.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public String getCameraman() {
        return cameraman;
    }

    public void setCameraman(String cameraman) {
        this.cameraman = cameraman == null ? null : cameraman.trim();
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName == null ? null : pictureName.trim();
    }

    public Integer getIndexSlide() {
        return indexSlide;
    }

    public void setIndexSlide(Integer indexSlide) {
        this.indexSlide = indexSlide;
    }

    public Integer getIndexAnimal() {
        return indexAnimal;
    }

    public void setIndexAnimal(Integer indexAnimal) {
        this.indexAnimal = indexAnimal;
    }

    public Integer getIndexPlant() {
        return indexPlant;
    }

    public void setIndexPlant(Integer indexPlant) {
        this.indexPlant = indexPlant;
    }

    public Integer getIndexScape() {
        return indexScape;
    }

    public void setIndexScape(Integer indexScape) {
        this.indexScape = indexScape;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction == null ? null : instruction.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getOwnerNumber() {
        return ownerNumber;
    }

    public void setOwnerNumber(String ownerNumber) {
        this.ownerNumber = ownerNumber == null ? null : ownerNumber.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Integer getSpecies() {
        return species;
    }

    public void setSpecies(Integer species) {
        this.species = species;
    }

    public Long getKeyone() {
        return keyone;
    }

    public void setKeyone(Long keyone) {
        this.keyone = keyone;
    }

    public Long getKeytwo() {
        return keytwo;
    }

    public void setKeytwo(Long keytwo) {
        this.keytwo = keytwo;
    }

    public String getKeythree() {
        return keythree;
    }

    public void setKeythree(String keythree) {
        this.keythree = keythree == null ? null : keythree.trim();
    }

    public Integer getIndexVideo() {
        return indexVideo;
    }

    public void setIndexVideo(Integer indexVideo) {
        this.indexVideo = indexVideo;
    }

    public Double getPathPrice() {
        return pathPrice;
    }

    public void setPathPrice(Double pathPrice) {
        this.pathPrice = pathPrice;
    }

    public Double getBigpathPrice() {
        return bigpathPrice;
    }

    public void setBigpathPrice(Double bigpathPrice) {
        this.bigpathPrice = bigpathPrice;
    }

    public Double getMidpathPrice() {
        return midpathPrice;
    }

    public void setMidpathPrice(Double midpathPrice) {
        this.midpathPrice = midpathPrice;
    }

    public Double getSmallpathPrice() {
        return smallpathPrice;
    }

    public void setSmallpathPrice(Double smallpathPrice) {
        this.smallpathPrice = smallpathPrice;
    }
}