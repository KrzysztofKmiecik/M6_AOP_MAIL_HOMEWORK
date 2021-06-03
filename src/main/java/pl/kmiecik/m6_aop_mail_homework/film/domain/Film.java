package pl.kmiecik.m6_aop_mail_homework.film.domain;

public class Film {

    private String title;
    private Integer year;
    private String producer;

    public Film(String title, Integer year, String producer) {
        this.title = title;
        this.year = year;
        this.producer = producer;
    }

    public Film() {
    }

    public String getTitle() {
        return title;
    }


    public Integer getYear() {
        return year;
    }


    public String getProducer() {
        return producer;
    }


    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", producer='" + producer + '\'' +
                '}';
    }
}
