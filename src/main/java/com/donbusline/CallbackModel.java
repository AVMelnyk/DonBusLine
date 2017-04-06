package com.donbusline;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import java.io.IOException;

        public class CallbackModel {
            private String start_point;
            private String end_point;
            private String surname;
            private String name;
            private String birthdate;
            private String tel;
            private String[] countriescodes = new String[2];
            private String date;
            private String time;
            private String comment;

            public CallbackModel(String start_point, String end_point, String surname, String name, String birthdate, String tel, String date, String time, String comment) {
                this.start_point = start_point;
                this.end_point = end_point;
                this.name = name;
                this.birthdate = birthdate;
                this.surname = surname;
                this.tel = tel;
                this.date = date;
                this.time = time;
                this.comment = comment;
                countriescodes[0] = "UA";
                countriescodes[1] = "RU";
            }

            public void notifyRecipient() {
                Application app = Application.getInstance();
                TelegramService telegramService = app.getService("TELEGRAM");
                try {
                    telegramService.sendMessage(app.getRecipientChatId(), "Рейс: " + start_point + " - " + end_point + "\n" + "Дата рейса: " + date+ "\n" + "Время рейса: " + time + "\n" + "ФИО: " + surname + " " + name + "\n" + "Дата рождения: " + birthdate + "\n" + "Номер телефона: " + tel  + "\n" + "Коментарий: " + comment);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            public boolean validePhoneNumber(String number) {
                boolean isValid = false;
                PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
                for (int i = 0; i < countriescodes.length; i++) {
                    try {
                        Phonenumber.PhoneNumber NumberProto = phoneUtil.parse(number, countriescodes[i]);
                        if (isValid = phoneUtil.isValidNumber(NumberProto)) {
                            return isValid;
                        }
                    } catch (NumberParseException e) {

                    }
                }
                return false;
            }
        }