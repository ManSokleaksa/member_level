package com.member_level.member_level.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;


public class MemberLevelUtil {

    public static class MemberInfo {
        private String tier;
        private String memberPercentage;
        private String dob;
        private int beans;
        private Date tierExpireDate;
        private int beanExtend;

        public MemberInfo(String tier, String memberPercentage, String dob, int beans, Date tierExpireDate,int beanExtend) {
            this.tier = tier;
            this.memberPercentage = memberPercentage;
            this.dob = dob;
            this.beans = beans;
            this.tierExpireDate = tierExpireDate;
            this.beanExtend = beanExtend;
        }

        public String getTier() { return tier; }
        public String getMemberPercentage() { return memberPercentage; }
        public String getDob() { return dob; }
        public int getBeans() { return beans; }
        public Date getTierExpireDate() { return tierExpireDate; }
        public int beanExtend() { return beanExtend; }


    }

    public static String replacePlaceHolders(String message, MemberInfo memberInfo) {
        if (message == null || memberInfo == null) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // or any desired date format

        message = message.replace("[tier]", memberInfo.getTier());
        message = message.replace("[member_percentage]", memberInfo.getMemberPercentage());
        message = message.replace("[member_expired_date]", sdf.format(memberInfo.getTierExpireDate()));
        message = message.replace("[golden_member_expired_date]", sdf.format(addMonthsToDate(new Date(),6)));
        message = message.replace("[dob]", memberInfo.getDob());
        message = message.replace("[bean_extend]", String.valueOf(memberInfo.beanExtend()));
        message = message.replace("[beans]", String.valueOf(memberInfo.getBeans()));

        return message;
    }
    private static Date addMonthsToDate(Date date, int months) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        localDate = localDate.plusMonths(months);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
