INSERT INTO artist (name, basic_info, img_url) VALUES ('Foster The People', null, '1-profile-image.jpg');
INSERT INTO album (date_created, img_url, name) VALUES ('2014-03-14', '1/cover.jpg', 'Supermodel');
INSERT INTO song (album_id, name, path, duration, album_cover_url) VALUES
                                                (1, 'Are You What You Want To Be', '1/AreYouWhatYouWantToBe.mp3', '00:04:30', '1/cover.jpg'),
                                                (1, 'Ask Yourself', '1/AskYourself.mp3', '00:04:23', '1/cover.jpg'),
                                                (1, 'Coming Of Age', '1/ComingOfAge.mp3', '00:04:39', '1/cover.jpg'),
                                                (1, 'Nevermind', '1/Nevermind.mp3', '00:05:18', '1/cover.jpg'),
                                                (1, 'Pseudologia Fantastica', '1/PseudologiaFantastica.mp3', '00:05:31', '1/cover.jpg'),
                                                (1, 'The Angelic Welcome Of Mr. Jones', '1/TheAngelicWelcomeOfMr. Jones.mp3', '00:00:33', '1/cover.jpg'),
                                                (1, 'Best Friend', '1/BestFriend.mp3',  '00:04:27', '1/cover.jpg'),
                                                (1, 'A Beginner''s Guide To Destroying The Moon', '1/ABeginner''sGuideToDestroyingTheMoon.mp3', '00:04:39', '1/cover.jpg'),
                                                (1, 'Goats in Trees', '1/GoatsInTrees.mp3', '00:05:10', '1/cover.jpg'),
                                                (1, 'The Truth', '1/TheTruth.mp3', '00:04:29', '1/cover.jpg'),
                                                (1, 'Fire Escape', '1/FireEscape.mp3', '00:04:21', '1/cover.jpg'),
                                                (1, 'Tabloid Super Junkie', '1/TabloidSuperJunkie.mp3', '00:06:00', '1/cover.jpg');
INSERT INTO album_artist (album_id, artist_id) VALUES (1, 1);
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

INSERT INTO artist (name, basic_info, img_url) VALUES ('Travis Scott', null, '2-profile-image.png');
INSERT INTO album (date_created, img_url, name) VALUES ('2015-09-04', '2/cover.png', 'Rodeo');
INSERT INTO song (album_id, name, path, duration, album_cover_url) VALUES
                                                  (2, 'Pornography', '2/Pornography.mp3', '00:03:51', '2/cover.png'),
                                                  (2, 'Oh My Dis Side (feat. Quavo)', '2/OhMyDisSide(feat.Quavo).mp3', '00:05:51', '2/cover.png'),
                                                  (2, '3500 (feat. Future & 2 Chainz)', '2/3500(feat.Future&2Chainz).mp3', '00:07:41', '2/cover.png'),
                                                  (2, 'Wasted (feat. Juicy J)', '2/Wasted(feat.JuicyJ).mp3', '00:03:55', '2/cover.png'),
                                                  (2, '90210', '2/90210.mp3', '00:05:39', '2/cover.png'),
                                                  (2, 'Pray 4 Love (feat. The Weeknd)', '2/Pray4Love(feat.TheWeeknd).mp3', '00:05:07', '2/cover.png'),
                                                  (2, 'Night Call (feat. Swae Lee & Chief Keef)', '2/NightCall(feat.SwaeLee&ChiefKeef).mp3', '00:05:21', '2/cover.png'),
                                                  (2, 'Piss On Your Grave (feat. Kanye West)', '2/PissOnYourGrave(feat.KanyeWest).mp3', '00:02:46', '2/cover.png'),
                                                  (2, 'Antidote', '2/Antidote.mp3', '00:04:22', '2/cover.png'),
                                                  (2, 'Impossible', '2/Impossible.mp3', '00:04:02', '2/cover.png'),
                                                  (2, 'Maria I''m Drunk, (feat. Justin Bieber & Young Thug)', '2/MariaI''mDrunk,(feat.JustinBieber&YoungThug).mp3', '00:05:49', '2/cover.png'),
                                                  (2, 'Flying High (feat. Toro y Moi)', '2/FlyingHigh(feat.ToroyMoi).mp3', '00:03:28', '2/cover.png'),
                                                  (2, 'I Can Tell', '2/ICanTell.mp3', '00:04:55', '2/cover.png'),
                                                  (2, 'Apple Pie', '2/ApplePie.mp3', '00:03:39', '2/cover.png');
INSERT INTO album_artist (album_id, artist_id) VALUES (2, 2);
INSERT INTO song_artist (artist_id, song_id) VALUES (2, 13),
                                                    (2, 14),
                                                    (2, 15),
                                                    (2, 16),
                                                    (2, 17),
                                                    (2, 18),
                                                    (2, 19),
                                                    (2, 20),
                                                    (2, 21),
                                                    (2, 22),
                                                    (2, 23),
                                                    (2, 24),
                                                    (2, 25),
                                                    (2, 26);
INSERT INTO users (activation_time, email, name, password, profile_picture_url) VALUES ('2023-11-13 17:31:00', 'm@mati.com', 'mati', 'test123', null),
                                                                                       ('2023-11-13 17:31:00', 'm@mati2.com', 'mati2', 'test1234', null);
INSERT INTO playlist (date_created, owner_id) VALUES ('2023-11-13', 1),
                                                     ('2023-11-12', 2);
INSERT INTO playlist_song (playlist_id, song_id) VALUES (1, 12),
                                                        (1, 13),
                                                        (1, 26);