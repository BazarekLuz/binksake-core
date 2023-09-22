INSERT INTO artist (name, basic_info) VALUES ('Foster The People', null);
INSERT INTO album (date_created, img_url, name) VALUES ('2014-03-14', 'supermodelcover.jpg', 'Supermodel');
INSERT INTO song (album_id, name, path) VALUES (1, 'A Beginner''s Guide To Destroying The Moon', 'ABeginner''sGuideToDestroyingTheMoon.mp3'),
                                               (1, 'Are You What You Want To Be', 'AreYouWhatYouWantToBe.mp3'),
                                               (1, 'Ask Yourself', 'AskYourself.mp3'),
                                               (1, 'Best Friend', 'BestFriend.mp3'),
                                               (1, 'Coming Of Age', 'ComingOfAge.mp3'),
                                               (1, 'Fire Escape', 'FireEscape.mp3'),
                                               (1, 'Goats in Trees', 'GoatsInTrees.mp3'),
                                               (1, 'Nevermind', 'Nevermind.mp3'),
                                               (1, 'Pseudologia Fantastica', 'PseudologiaFantastica.mp3'),
                                               (1, 'Tabloid Super Junkie', 'TabloidSuperJunkie.mp3'),
                                               (1, 'The Angelic Welcome Of Mr. Jones', 'TheAngelicWelcomeOfMr. Jones.mp3'),
                                               (1, 'The Truth', 'TheTruth.mp3');
INSERT INTO artist_album (album_id, artist_id) VALUES (1, 1);
INSERT INTO song_artist (artist_id, song_id) VALUES (1, 1),
                                                    (1, 2),
                                                    (1, 3),
                                                    (1, 4),
                                                    (1, 5),
                                                    (1, 6),
                                                    (1, 7),
                                                    (1, 8),
                                                    (1, 9),
                                                    (1, 10),
                                                    (1, 11),
                                                    (1, 12);