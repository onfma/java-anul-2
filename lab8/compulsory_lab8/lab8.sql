-- Create tables
CREATE TABLE artists (
  id NUMBER(10) PRIMARY KEY,
  name VARCHAR2(100) NOT NULL
);

CREATE TABLE genres (
  id NUMBER(10) PRIMARY KEY,
  name VARCHAR2(100) NOT NULL
);

CREATE TABLE albums (
  id NUMBER(10) PRIMARY KEY,
  release_year NUMBER(4) NOT NULL,
  title VARCHAR2(100) NOT NULL,
  artist_id NUMBER(10) NOT NULL,
  CONSTRAINT fk_albums_artists
    FOREIGN KEY (artist_id)
    REFERENCES artists(id)
    ON DELETE CASCADE
);

CREATE TABLE album_genres (
  album_id NUMBER(10) NOT NULL,
  genre_id NUMBER(10) NOT NULL,
  CONSTRAINT pk_album_genres
    PRIMARY KEY (album_id, genre_id),
  CONSTRAINT fk_album_genres_albums
    FOREIGN KEY (album_id)
    REFERENCES albums(id)
    ON DELETE CASCADE,
  CONSTRAINT fk_album_genres_genres
    FOREIGN KEY (genre_id)
    REFERENCES genres(id)
    ON DELETE CASCADE
);

-- Insert data into tables
INSERT INTO artists (id, name) VALUES (1, 'The Beatles');
INSERT INTO artists (id, name) VALUES (2, 'Queen');
INSERT INTO artists (id, name) VALUES (3, 'Pink Floyd');

INSERT INTO genres (id, name) VALUES (1, 'Rock');
INSERT INTO genres (id, name) VALUES (2, 'Pop');
INSERT INTO genres (id, name) VALUES (3, 'Progressive rock');

INSERT INTO albums (id, release_year, title, artist_id) VALUES (1, 1967, 'Sgt. Pepper''s Lonely Hearts Club Band', 1);
INSERT INTO albums (id, release_year, title, artist_id) VALUES (2, 1975, 'A Night at the Opera', 2);
INSERT INTO albums (id, release_year, title, artist_id) VALUES (3, 1979, 'The Wall', 3);

INSERT INTO album_genres (album_id, genre_id) VALUES (1, 1);
INSERT INTO album_genres (album_id, genre_id) VALUES (1, 2);
INSERT INTO album_genres (album_id, genre_id) VALUES (2, 1);
INSERT INTO album_genres (album_id, genre_id) VALUES (2, 2);
INSERT INTO album_genres (album_id, genre_id) VALUES (2, 3);
INSERT INTO album_genres (album_id, genre_id) VALUES (3, 1);
INSERT INTO album_genres (album_id, genre_id) VALUES (3, 3);
