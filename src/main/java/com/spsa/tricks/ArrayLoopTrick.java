package com.spsa.tricks;

import java.util.*;
import java.util.stream.*;

public class ArrayLoopTrick {
    public static void main(String[] argv) {
        String[] counts = { "900,google.com", "60,mail.yahoo.com", "10,mobile.sports.yahoo.com", "40,sports.yahoo.com",
                "300,yahoo.com", "10,stackoverflow.com", "20,overflow.com", "5,com.com", "2,en.wikipedia.org",
                "1,m.wikipedia.org", "1,mobile.sports", "1,google.co.uk" };

        ArrayLoopTrick instance = new ArrayLoopTrick();
        Map<String, Integer> summary = instance.calculateClicksByDomain(counts);
        summary.entrySet().stream().sorted(Comparator.comparingInt(s -> s.getValue()))
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }

    public Map<String, Integer> calculateClicksByDomain(String[] counts) {
        Map<String, Integer> summary = new HashMap<>();
        Stream.of(counts).forEach(d -> {

            String[] data = d.split(",");
            int count = Integer.parseInt(data[0]);

            String domain = data[1];
            addToSummary(summary, domain, count);

            String[] subdomains = domain.split("\\.");
            addSubdomains(summary, subdomains, count);
        });
        return summary;
    }

    private void addSubdomains(Map<String, Integer> summary, String[] subdomains, int count) {
        Optional<String> domainNameOpt = Optional.empty();
        for (int i = subdomains.length - 1; i > 0; i--) { // key logic
            String subDomain = subdomains[i];
            String domainName = domainNameOpt.map(sd -> subDomain + "." + sd).orElse(subDomain);
            domainNameOpt = Optional.of(domainName);
            addToSummary(summary, domainName, count);
        }
    }

    private void addToSummary(Map<String, Integer> summary, String domain, int count) {
        if (summary.containsKey(domain)) {
            summary.put(domain, summary.get(domain) + count);
        } else {
            summary.put(domain, count);
        }
    }
}
