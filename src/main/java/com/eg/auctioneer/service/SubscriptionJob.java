package com.eg.auctioneer.service;

import com.eg.auctioneer.repo.AuctionSubscriptionRepo;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SubscriptionJob implements Job{
    private AuctionSubscriptionRepo auctionSubscriptionRepo;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("SubscriptionJob started");
        System.out.println("SubscriptionJob ended");

    }
}
