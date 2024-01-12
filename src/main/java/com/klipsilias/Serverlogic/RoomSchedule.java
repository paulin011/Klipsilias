package com.klipsilias.Serverlogic;

import jakarta.persistence.*;

@Entity
@Table(name = "room_schedules")
public class RoomSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "is_not_available")
    private Boolean isNotAvailable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Boolean getNotAvailable() {
        return isNotAvailable;
    }

    public void setNotAvailable(Boolean notAvailable) {
        isNotAvailable = notAvailable;
    }
// getters and setters...

}