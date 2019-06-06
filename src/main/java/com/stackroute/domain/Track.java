package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "track")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Track {
    @Id
            @Column(name = "id")
    int id;

    @Column(name = "trackname")
    String trackName;

    @Column(name = "comments")
    String comments;


}
